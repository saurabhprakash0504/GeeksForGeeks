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
        CircuitBreaker cb = new CircuitBreaker();

        long t = 0;

        // Service B: trigger OPEN after 3 failures within TEN_MIN
        System.out.println("B fail1 allowed=" + cb.execute("B", t += 1000, true)); // allowed (still closed)
        System.out.println("B fail2 allowed=" + cb.execute("B", t += 1000, true)); // allowed
        System.out.println("B fail3 allowed=" + cb.execute("B", t += 1000, true)); // triggers OPEN -> returns false
        long openedAtB = t;

        // Request during OPEN should be blocked
        System.out.println("B request during open allowed=" + cb.execute("B", t += 1000, false)); // false

        // Advance to exactly FIVE_MIN after openedAt to allow a half-open probe
        t = openedAtB + FIVE_MIN;
        System.out.println("B half-open probe allowed=" + cb.execute("B", t, false)); // transitions OPEN->HALF_OPEN and allows probe (returns true)

        // Probe succeeds -> circuit should close
        System.out.println("B probe result (success) allowed=" + cb.execute("B", t + 1, false)); // HALF_OPEN sees success -> CLOSED

        // Service C: failures spaced out beyond TEN_MIN should not open circuit
        System.out.println("C fail1 allowed=" + cb.execute("C", t += 1000, true)); // allowed
        System.out.println("advance time beyond TEN_MIN to expire previous failures");
        t += TEN_MIN + 1000;
        System.out.println("C fail2 allowed=" + cb.execute("C", t, true)); // allowed (previous expired)
        System.out.println("C fail3 allowed=" + cb.execute("C", t + 1000, true)); // still allowed (only 2 within TEN_MIN)

        // Demonstrate HALF_OPEN failure -> re-open
        // Re-trigger B to open again quickly
        System.out.println("Re-trigger B: fail1 allowed=" + cb.execute("B", t += 1000, true));
        System.out.println("Re-trigger B: fail2 allowed=" + cb.execute("B", t += 1000, true));
        System.out.println("Re-trigger B: fail3 allowed=" + cb.execute("B", t += 1000, true)); // opens
        long openedAtB2 = t;

        // Advance to half-open and make the probe fail
        t = openedAtB2 + FIVE_MIN;
        System.out.println("B half-open probe allowed=" + cb.execute("B", t, false)); // allow probe
        System.out.println("B probe result (failure) allowed=" + cb.execute("B", t + 1, true)); // HALF_OPEN sees failure -> re-open (returns false)
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


