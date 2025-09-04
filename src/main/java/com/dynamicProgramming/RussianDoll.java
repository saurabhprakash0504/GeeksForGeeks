package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class RussianDoll {

    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] ==b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });

        ArrayList<Integer> al = new ArrayList<Integer>();
        int len = envelopes.length;
        for(int ii=0;ii< len;ii++){

            int i = Collections.binarySearch(al, envelopes[ii][1]);
            if(i < 0){
                i = -(i+1);
            }

            if(i == al.size()){
                al.add(envelopes[ii][1]);
            }else{
                al.set(i, envelopes[ii][1]);
            }


        }
        return al.size();
    }
}
