package com.companyInterview.visa;

import java.util.LinkedHashMap;
import java.util.Map;

/*

    Octavian Lunar Phase

    In the land of Octavia, the lunar cycle consists of 8 distinct phases that repeat in a fixed order:
    NewMoon, Crescent, Quarter, Gibbous, Full, Waning, Eclipse, Twilight.

    The months in Octavia have the same number of days as the Gregorian calendar:
    January (31), February (28), March (31), April (30), May (31), June (30),
    July (31), August (31), September (30), October (31), November (30), December (31).

    You are given:

    • a season name
    • a day number within that season
    • the lunar phase on January 1st

    Given a starting month, a day count, and an initial lunar phase,
    determine the lunar phase after the specified number of days have passed.

    Example:
    Input: season = "January", dayCount = 4, initialPhase = "Full"
    Output: "Waning"

    Input: season = "March", dayCount = 7, initialPhase = "Crescent"
    Output: "Gibbous"

    Input: season = "April", dayCount = 1, initialPhase = "Gibbous"
    Output: "Full"

 */

public class OctavianLunarPhase {

    public static void main(String[] args) {
        //System.out.println(getLunarPhase("January", 4, "Full"));
       // System.out.println(getLunarPhase("March", 7, "Crescent"));
        System.out.println(getLunarPhase("April", 1, "Gibbous"));

    }

    public static String getLunarPhase(String season, int dayCount, String initialPhase) {

        final String[] phases = {
                "NewMoon", "Crescent", "Quarter", "Gibbous",
                "Full", "Waning", "Eclipse", "Twilight"
        };

        LinkedHashMap<String, Integer> phaseIndexMap = new LinkedHashMap<>();
        for (int i = 0; i < phases.length; i++) {
            phaseIndexMap.put(phases[i], i);
        }

        final LinkedHashMap<String, Integer> monthDays = new LinkedHashMap<>();
        // monthDays.putAll(Map.ofEntries(
        monthDays.put("January", 31);
        monthDays.put("February", 28);
        monthDays.put("March", 31);
        monthDays.put("April", 30);
        monthDays.put("May", 31);
        monthDays.put("June", 30);
        monthDays.put("July", 31);
        monthDays.put("August", 31);
        monthDays.put("September", 30);
        monthDays.put("October", 31);
        monthDays.put("November", 30);
        monthDays.put("December", 31);


        int totalNumberOfDays = 0;

        for (Map.Entry<String, Integer> entry : monthDays.entrySet()) {
            String month = entry.getKey();
            int daysInMonth = entry.getValue();

            if (month.equals(season)) {
                // totalNumberOfDays += dayCount;
                break;
            } else {
                totalNumberOfDays += daysInMonth;
            }
        }

        totalNumberOfDays = totalNumberOfDays + dayCount - 1;
        int rem = totalNumberOfDays;
       // System.out.println("rem < " + rem);
        int initialPhaseIndex = phaseIndexMap.get(initialPhase);
        rem = (rem + initialPhaseIndex) % 8;


        return phases[rem];


    }
}
