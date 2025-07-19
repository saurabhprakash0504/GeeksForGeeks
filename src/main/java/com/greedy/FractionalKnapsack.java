package com.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class FractionalKnapsack {

    public static void main(String[] args) {
       int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int capacity = 50;

        System.out.println(fractionalKnapsack(val, wt, capacity));

    }
    static double fractionalKnapsack(int[] values, int[] weights, int w) {
        // code here
        ArrayList<Res1> al = new ArrayList<Res1>();
        for(int i=0;i< values.length;i++){
            al.add(new Res1(values[i], weights[i], values[i]/(weights[i]*1.0)));
        }

        Collections.sort(al);

        double total =0.0;

        //  int i=0;
        //  while(w != 0){
        for(int i=0;i<al.size();i++){
            //  System.out.println("val >> "+ al.get(i).val);
            if(w > al.get(i).wt){
                total = total + al.get(i).val;
                w = w - al.get(i).wt;
            }else{
                // System.out.println("total >> "+ total);
                // double d1 = al.get(i).val * (w/al.get(i).wt )

                total = total + (al.get(i).val * ((w *1.0)/al.get(i).wt));
                w = 0;
            }

            if(w == 0){
                return total;
            }
            //  i++;
        }

        return total;
    }
}


class Res1 implements Comparable<Res1>{

    int val;
    int wt;
    Double div;

    Res1(int v, int w, double d){
        val = v;
        wt = w;
        div = d;
    }

    public int compareTo(Res1 r){
        // return  r.div - this.div;
        Double dd = r.div;
        return dd.compareTo(div);
    }
}