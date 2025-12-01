package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MeetingScheduling {

    public int maxMeetings(int start[], int end[]) {
        // add your code here
        ArrayList<Activity> list = sort(start, end);

        int count = 1;
        int prev = 0;
        for(int i=1;i<list.size();i++){
            if(list.get(prev).e < list.get(i).s){
                count++;
                prev = i;
            }
        }

        return count;
    }

    ArrayList<Activity> sort(int[] start, int[] end){
        ArrayList<Activity> list = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            list.add(new Activity(start[i], end[i]));
        }

        Collections.sort(list, Comparator.comparingInt(a -> a.e));

        return list;
    }
}

class Activity{
    int s;
    int e;

    Activity(int s, int e){
        this.s = s;
        this.e = e;
    }
}

