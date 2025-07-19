package com.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ActivitySelectionProblem {

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] finish = {2, 4, 6, 7, 9, 9};

        System.out.println(activitySelection(start,finish));


    }

    public static int activitySelection(int[] start, int[] finish) {
        // code here
        ArrayList<Res> al = new ArrayList<Res>();
        for (int i = 0; i < start.length; i++) {
            al.add(new Res(start[i], finish[i]));
        }
        Collections.sort(al);

        int count = 1;

        Res first = al.get(0);

        for (int i = 1; i < al.size(); i++) {

            Res sec = al.get(i);
            if (first.finish < sec.start) {
                count++;
                first = sec;
            }

        }

        return count;
    }
}


class Res implements Comparable<Res> {

    int start;
    int finish;

    Res(int s, int f) {
        start = s;
        finish = f;
    }

    public int compareTo(Res r) {
        return this.finish - r.finish;
    }
}

