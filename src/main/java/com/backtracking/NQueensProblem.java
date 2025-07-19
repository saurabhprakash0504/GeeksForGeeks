package com.backtracking;

import java.util.ArrayList;

public class NQueensProblem {

    public static void main(String[] args) {

    }

    // User function Template for Java


    public static ArrayList<ArrayList<Integer>> nQueen(int n) {

        int[][] output = new int[n][n];
        ArrayList<ArrayList<Integer>> fl = new ArrayList<>();
        find(n, output, 0, fl);

        return fl;

    }

    static void find(int n, int[][] output, int col, ArrayList<ArrayList<Integer>> fl) {

        if (col == n) {
            ArrayList<Integer> al = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (output[i][j] == 1) {

                        al.add(j + 1);
                        break;
                    }
                }

            }
            fl.add(al);
            return;
        }

        for (int r = 0; r < n; r++) {
            if (isSafe(n, r, output, col)) {

                output[r][col] = 1;
                find(n, output, col + 1, fl);
                output[r][col] = 0;
            }
        }


    }


    static boolean isSafe(int n, int r, int[][] output, int c) {
        //previous column check
        int j = 0;
        while (j < c) {
            if (output[r][j] == 1) {
                return false;
            }
            j++;
        }

        //previous up diagonal check
        int i = r;
        j = c;
        while (i >= 0 && j >= 0) {
            if (output[i][j] == 1) {
                return false;
            }
            i--;
            j--;

        }


        //previous down diagonal check
        i = r;
        j = c;
        while (i < n && j >= 0) {
            if (output[i][j] == 1) {
                return false;
            }
            i++;
            j--;

        }

        return true;


    }
}

