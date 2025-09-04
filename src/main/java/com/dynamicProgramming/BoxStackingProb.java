package com.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BoxStackingProb {

    public static void main(String[] args) {
        int height[] = {4, 1, 4, 10};
        int width[] = {6, 2, 5, 12};
        int length[] = {7, 3, 6, 32};

        System.out.println(maxHeight(height, width, length));

    }

    static class Box {
        int l, w, h;

        Box(int l, int w, int h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }
    }

    static class BoxComparator implements Comparator<Box> {
        public int compare(Box b1, Box b2) {
            if (b1.l == b2.l)
                return b1.w - b2.w;
            return b1.l - b2.l;
        }
    }

    public static int maxHeight(int[] height, int[] width, int[] length) {
        int n = height.length;
        ArrayList<Box> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = height[i], b = width[i], c = length[i];
            list.add(new Box(a, b, c));
            list.add(new Box(b, a, c));
            list.add(new Box(a, c, b));
            list.add(new Box(c, a, b));
            list.add(new Box(b, c, a));
            list.add(new Box(c, b, a));
        }

        // Sort boxes by base dimensions
        Collections.sort(list, new BoxComparator());

        /*int[] dp = new int[list.size()];
        int maxHeight = 0;

        for (int i = 0; i < list.size(); i++) {
            dp[i] = list.get(i).h;
            for (int j = 0; j < i; j++) {
                if (list.get(i).l > list.get(j).l && list.get(i).w > list.get(j).w) {
                    dp[i] = Math.max(dp[i], dp[j] + list.get(i).h);
                }
            }
            maxHeight = Math.max(maxHeight, dp[i]);
        }

        return maxHeight;*/
        int m = list.size();
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return findMem3(list, m, 0, -1, dp);
    }


    static int findMem3(ArrayList<Box> arr, int len, int ind, int maxInd, int[][] dp) {
        if (ind >= len) {
            return 0;
        }

        if (dp[ind][maxInd + 1] != -1) {
            return dp[ind][maxInd + 1];
        }

        int inc = 0;
        if (maxInd == -1 ||
                (arr.get(ind).l > arr.get(maxInd).l &&
                        arr.get(ind).w > arr.get(maxInd).w)) {
            inc = arr.get(ind).h + findMem3(arr, len, ind + 1, ind, dp);
        }

        int exc = findMem3(arr, len, ind + 1, maxInd, dp);


        return dp[ind][maxInd + 1] = Integer.max(inc, exc);

    }
}
