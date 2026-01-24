package com.companyInterview.wise;

import java.util.*;

/*

    We have a web client that makes requests to Service B and Service C.
    If either service fails 3 times within 10 minutes, we should stop making requests to that service
    for 5 minutes (circuit breaker open).
    After 5 minutes, we should try again (circuit breaker half-open/closed).
    We need to implement this logic in the `WebClient.execute(Request)` method. (CIRCUIT BREAKER)

 */
public class CircuitBreaker {

    public static void main(String[] args) {
        System.out.println("Circuit Breaker Implementation");
    }

    private static final long TEN_MIN = 10 * 60 * 1000;

    private static final long FIVE_MIN = 5 * 60 * 1000;


    private static class ServiceState {

        Deque<Long> failures = new ArrayDeque<>();

        String state = "CLOSED"; // CLOSED, OPEN, HALF_OPEN

        long openedAt = -1;

    }


    private Map<String, ServiceState> services = new HashMap<>();


    public CircuitBreaker() {

        services.put("B", new ServiceState());

        services.put("C", new ServiceState());

    }


    public boolean execute(String service, long timestamp, boolean isFailure) {

        ServiceState s = services.get(service);


        switch (s.state) {


            case "OPEN":

                if (timestamp - s.openedAt >= FIVE_MIN) {

                    s.state = "HALF_OPEN";

                    return true; // allow test request

                }

                return false;


            case "HALF_OPEN":

                if (isFailure) {

                    s.state = "OPEN";

                    s.openedAt = timestamp;

                    return false;

                } else {

                    s.state = "CLOSED";

                    s.failures.clear();

                    return true;

                }


            case "CLOSED":

                if (isFailure) {

                    s.failures.addLast(timestamp);

                    while (!s.failures.isEmpty() &&

                            timestamp - s.failures.peekFirst() > TEN_MIN) {

                        s.failures.pollFirst();

                    }

                    if (s.failures.size() >= 3) {

                        s.state = "OPEN";

                        s.openedAt = timestamp;

                        return false;

                    }

                }

                return true;

        }


        return true;

    }

}


