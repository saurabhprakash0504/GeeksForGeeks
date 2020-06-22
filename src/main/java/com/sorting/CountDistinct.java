package com.sorting;

import java.util.HashMap;

public class CountDistinct {

	public static void main(String[] args) {
		int[] A= {1 ,2, 1, 3, 4, 2, 3};
		countDistinct(A,4,A.length);
	}

	static void countDistinct(int A[], int k, int n) {
        HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
        for(int i=0;i<k;i++){
            if(h.containsKey(A[i])){
                 h.put(A[i], h.get(A[i])+1);
            }else{
                h.put(A[i],1);
            }
        }
        System.out.print(h.size()+" ");

        for(int i=k;i<n;i++){

             int count = h.get(A[i-k]);
             if(count-1 == 0){
                 h.remove(A[i-k]);
             }else{
                 h.put(A[i-k], count-1);
             }

            if(h.containsKey(A[i])){
                 h.put(A[i], h.get(A[i])+1);
            }else{
                h.put(A[i],1);
            }

           // h.add(A[i]);
            System.out.print(h.size()+" ");
        }
    }
}
