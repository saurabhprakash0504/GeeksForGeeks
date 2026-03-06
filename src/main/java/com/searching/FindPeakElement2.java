package com.searching;

import java.util.Arrays;

public class FindPeakElement2 {

    public static void main(String[] args) {

        int[][] mat = {{1,4},{3,2}};
        int[] ans = findPeakGrid(mat);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] findPeakGrid(int[][] mat) {

        int l = 0;
        int r = mat[0].length-1;

        while(l <= r){
            int m = l + (r-l)/2;

            int currRow = 0;
            int maxiRow = 0;
            while(currRow <= mat.length -1){
                if( mat[currRow][m] > mat[maxiRow][m]){
                    maxiRow = currRow;
                }
                currRow++;
            }

            int maxVal = mat[maxiRow][m];

            int left = (m > 0)? mat[maxiRow][m-1] : -1;
            int right = (m < mat[0].length-1) ? mat[maxiRow][m+1] : -1;

            if(maxVal > left && maxVal > right){
                return new int[] {maxiRow, m};
            }else if(maxVal > left && maxVal < right){
                l = m +1;
            }else {
                r = m -1;
            }
        }

        return new int[]{-1, -1};
    }
}
