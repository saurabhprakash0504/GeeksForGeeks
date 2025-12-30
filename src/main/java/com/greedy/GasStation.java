package com.greedy;

public class GasStation {

    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        GasStation gs = new GasStation();
        int res = gs.startStation(gas, cost);
        System.out.println(res);

    }

    public int startStation(int[] gas, int[] cost) {
        // code here
        int totalGas = 0;
        int totalCost = 0;
        for(int i=0;i<gas.length;i++){
            totalGas = totalGas + gas[i];
            totalCost = totalCost + cost[i];
        }

        if(totalGas < totalCost){
            return -1;

        }

        int rem = 0;
        int j=0;
        for(int i=0;i< gas.length;i++){
            rem = rem + gas[i] - cost[i];
            if(rem < 0){
                rem = 0;
                j=i+1;
            }
        }

        return j;
    }
}
