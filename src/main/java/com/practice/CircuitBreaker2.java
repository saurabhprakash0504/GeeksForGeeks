package com.practice;

import java.util.*;

public class CircuitBreaker2 {

    static class ServiceState {

        String state = "CLOSED";
        long openedAt = 0;
        Queue<Long> q = new LinkedList<>();
    }

    private final Map<String, ServiceState> services;

    CircuitBreaker2() {
        services = new HashMap<>();
        services.put("B", new ServiceState());
        services.put("C", new ServiceState());
    }

    public boolean execute(String service, long timestamp, boolean isFailure) {

        ServiceState state = services.get(service);

        switch (state.state) {

            case "OPEN":

                if (timestamp - state.openedAt > 5 * 60 * 1000) {

                    state.state = "HALF_OPEN";
                    state.openedAt = timestamp;
                    return true;

                }

                return false;

            case "HALF_OPEN":

                if (isFailure) {
                    state.state = "OPEN";
                    state.openedAt = timestamp;
                    return false;
                } else {
                    state.state = "CLOSED";
                    state.q.clear();
                    return true;
                }

            case "CLOSED":

                if (isFailure) {
                    state.q.offer(timestamp);
                    while (!state.q.isEmpty() && timestamp - state.q.peek() > 10 * 60 * 1000) {
                        state.q.poll();
                    }

                    if (state.q.size() >= 3) {
                        state.state = "OPEN";
                        state.openedAt = timestamp;
                        return false;
                    } else {
                        state.q.offer(timestamp);
                        return true;
                    }
                } else {
                    return true;
                }
        }
        return true;
    }
}
