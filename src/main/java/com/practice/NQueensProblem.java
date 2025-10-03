package com.practice;

import java.util.ArrayList;

public class NQueensProblem {

    public static void main(String[] args) {
        int n = 4;
        NQueensProblem nq = new NQueensProblem();
        ArrayList<ArrayList<Integer>> result = nq.nQueen(n);
        System.out.println(result);
    }

    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> l = new ArrayList<>();

        find(l, list, 0, n);

        return list;
    }

    void find(ArrayList<Integer> l, ArrayList<ArrayList<Integer>> list, int row, int n){
        if(row == n){
            list.add(new ArrayList<>(l));
            // list.add(l);
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafe(l, col, row, n)){
                l.add(col+1);
                find(l, list, row+1, n);
                l.remove(l.size()-1);
            }
        }
    }


    boolean isSafe(ArrayList<Integer> l, int col, int row, int n){

        if(l.contains(col+1)){
            return false;
        }

        //previos left check
        int r = row-1;
        int leftDiag = col-1;
        while(r>=0){
            int val = l.get(r);
            if(val == leftDiag+1){
                return false;
            }
            r= r-1;
            leftDiag--;
        }

        // previous right check
        int r2 = row -1;
        int rightDiag = col+1;
        while(r2>=0){
            int val = l.get(r2);
            if(val == rightDiag+1){
                return false;
            }
            r2= r2-1;
            rightDiag++;
        }

        return true;
    }
}
