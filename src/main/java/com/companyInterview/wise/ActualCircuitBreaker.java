package com.companyInterview.wise;

import com.practice.CircuitBreaker2;

import java.io.*;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.*;
import java.text.*;
import java.util.stream.*;
import java.net.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

/*

    We have a web client that makes requests to Service B and Service C.
    If either service fails 3 times within 10 minutes, we should stop making requests to that service
    for 5 minutes (circuit breaker open).
    After 5 minutes, we should try again (circuit breaker half-open/closed).
    We need to implement this logic in the `WebClient.execute(Request)` method. (CIRCUIT BREAKER)

 */

abstract class Request {
    String host;

    abstract Response call(); // This makes request to external server
}

class Response {
    int status;
    String body;
}

public class ActualCircuitBreaker {

    public static void main(String[] args) throws IOException {

        List<String> requests = List.of(
                "1,service_b/api,200",
                "2,service_b/api,200",
                "3,service_b/api,500"
        );

        List<String> results = handleRequests(requests);
        for (String status : results) {
            System.out.println(status);
        }
    }

    private static List<String> handleRequests(List<String> requests) {
        ActualCircuitBreaker circuitBreaker = new ActualCircuitBreaker();
        List<String> responseStatuses = new ArrayList<>();
        for (String request : requests) {
            String[] requestParts = request.split(",");
            var requestTime = Integer.valueOf(requestParts[0].trim());
            // Clock.setCurrentTime(requestTime);
            var requestAPIHost = requestParts[1].trim();
            var responseStatus = requestParts[2].trim();
            var mockRequest = new MockRequest(requestAPIHost, Integer.valueOf(responseStatus));
            try {
                var response = circuitBreaker.execute(mockRequest);
                responseStatuses.add(String.valueOf(response.status));
            } catch (Exception ex) {
                // Candidate can throw an exception or return 429 when web-client blocks the request
                responseStatuses.add("429");
            }
        }
        return responseStatuses;
    }

    // Mocked Request class to handle mocked responses
    static class MockResponse extends Response {
        public MockResponse(int status, String content) {
            super.status = status;
            super.body = content;
        }
    }


    // Mocked Request class to handle request and response codes via test-cases
    static class MockRequest extends Request {
        int mockResponseCode;

        public MockRequest(String host, int mockResponseCode) {
            super.host = host;
            this.mockResponseCode = mockResponseCode;
        }

        public Response call() {
            try {
                return new MockResponse(Integer.valueOf(this.mockResponseCode), null);
            } catch (Exception e) {
                return null;
            }
        }
    }

    private int getCurrentTimeInMinutes() {
        return LocalDateTime.now().getMinute();
    }

    //
    //FROM HERE: Candidate's code to implement Circuit Breaker pattern
    Map<String, CircuitBreaker> map = new HashMap<>();

    private CircuitBreaker getBreaker(String host) {
        return map.computeIfAbsent(host, h -> new CircuitBreaker());
    }

    //Write your code here
    //WE need to implement this logic in the `WebClient.execute(Request)` method. (CIRCUIT BREAKER)
    public Response execute(Request request) throws Exception {

        CircuitBreaker cb = getBreaker(request.host);
        int now = getCurrentTimeInMinutes();

        // -------------------------
        // 1. HALF-OPEN STATE
        // -------------------------
        if (now == cb.openUntil) {
            Response trial = request.call();

            if (trial.status == 200) {
                cb.reset();
                return trial;
            } else {
                cb.trip(now);
                Response r = new Response();
                r.status = 500;
                return r;
            }
        }

        // -------------------------
        // 2. OPEN STATE
        // -------------------------
        if (now < cb.openUntil) {
            Response r = new Response();
            r.status = 500;
            return r;
        }

        // -------------------------
        // 3. CLOSED STATE
        // -------------------------
        Response response = request.call();

        if (response.status == 200) {
            cb.cleanup(now);
            return response;
        }

        // Failure
        cb.recordFailure(now);

        if (cb.failures.size() >= 3) {
            cb.trip(now); // breaker opens AFTER returning this failure
        }

        return response;
    }
}

class CircuitBreaker {

    Queue<Integer> failures = new LinkedList<>();
    int openUntil = -1; // -1 means CLOSED

    void cleanup(int now) {
        while (!failures.isEmpty() && now - failures.peek() > 10) {
            failures.poll();
        }
    }

    void recordFailure(int now) {
        failures.add(now);
        cleanup(now);
    }

    void trip(int now) {
        openUntil = now ; // breaker open for 5 minutes
    }

    void reset() {
        openUntil = -1;
        failures.clear();
    }
}


