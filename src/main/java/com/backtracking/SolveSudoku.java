package com.backtracking;

public class SolveSudoku {

    public static void main(String[] args) {
        int[][] mat = {};
        solveSudoku(mat);
    }


    static void solveSudoku(int[][] mat) {
        // code here
        int n = mat.length;
        solve(mat, n);

    }

    static boolean solve(int[][] mat, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j] ==0){
                    for(int k=1;k<=n;k++){
                        if(isSafe(mat, k, i, j, n)){
                            mat[i][j] = k;
                            if(solve(mat, n)){
                                return true;
                            }
                            mat[i][j] =0;
                        }
                    }
                    return false;
                }
            }
        }

        return true;

    }


    static boolean isSafe(int[][] mat, int k, int x, int y, int n){
        for(int i =0;i<n ;i++){
            if(mat[x][i] == k){
                return false;
            }
        }

        for(int j=0;j< n;j++){
            if(mat[j][y] == k){
                return false;
            }
        }

        double v = Math.sqrt(n);
        int val = (int) v;
        int r = x - x% val;
        int c = y - y% val;

        for(int i=0;i<val;i++){
            for(int j=0;j < val;j++){
                if(mat[i+r][j+c] == k){
                    return false;
                }
            }
        }

        return true;
    }
}
