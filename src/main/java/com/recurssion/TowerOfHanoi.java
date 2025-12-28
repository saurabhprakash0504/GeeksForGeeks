package com.recurssion;

import java.util.ArrayList;

public class TowerOfHanoi {
    public static long moves;

    public static void main(String[] args) {
        toh(2, 1, 2, 3);
    }

    public static void toh(int N, int from, int to, int aux) {
        if (N == 1) {
            System.out.println("move disk " + 1 + " from rod " + from + " to rod " + to);
            moves++;
            return;
        }
        toh(N - 1, from, aux, to);
        System.out.println("move disk " + N + " from rod " + from + " to rod " + to);
        moves++;
        toh(N - 1, aux, to, from);
        // System.out.println(moves);
    }


    //APPROACH 2 - SIMILAR TO PERMUTATION CODE

    public ArrayList<String> towerOfHanoi(int n) {
        ArrayList<String> al = new ArrayList<>();
        solve(n, 'A', 'C', 'B', al);
        return al;
    }

    void solve(int n, char src, char dest, char aux, ArrayList<String> al) {
        if (n == 0) {
            return;
        }

        solve(n - 1, src, aux, dest, al);

        al.add("move disk " + n + " from rod " + src + " to rod " + dest);

        solve(n - 1, aux, dest, src, al);
    }

}
