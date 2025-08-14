package com.practice;

import java.time.*;
import java.lang.*;

import java.util.*;

public class Test {

   /* class WebClient {
        // Map of API host to a queue of timeout timestamps (in minutes)
        private Map<String, Deque<Integer>> timeoutMap = new HashMap<>();

        private int getCurrentTimeInMinutes() {
            return Clock.getCurrentTimeInMinutes();
        }

        // BLOCK_TIME_WINDOW in minutes
        private static final int TIME_WINDOW = 5;
        // Threshold for timeouts before blocking
        private static final int TIMEOUT_THRESHOLD = 3;

        public Response execute(Request request) throws Exception {
            String host = request.host;
            int now = getCurrentTimeInMinutes();

            // Get or create the queue for this host
            timeoutMap.putIfAbsent(host, new LinkedList<>());
            Deque<Integer> timeouts = timeoutMap.get(host);

            // Prune old timeouts (older than 5 minutes ago)
            while (!timeouts.isEmpty() && now - timeouts.peekFirst() >= TIME_WINDOW) {
                timeouts.pollFirst();
            }

            // If 3 or more recent timeouts, block this request
            if (timeouts.size() >= TIMEOUT_THRESHOLD) {
                throw new Exception("Blocked: Too many recent timeouts for " + host);
                // Or, as per test harness, return new Response with 429 status:
                // Response blockResp = new Response();
                // blockResp.status = 429;
                // blockResp.body = null;
                // return blockResp;
            }

            // Otherwise, make the request
            Response resp = request.call();

            // Only interested in status 500 now
            if (resp.status == 500) {
                timeouts.addLast(now);
            }
            return resp;
        }
    }
*/
}
