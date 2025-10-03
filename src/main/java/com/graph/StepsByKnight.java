package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class StepsByKnight {

    public static void main(String[] args) {
        StepsByKnight sbk = new StepsByKnight();
        int knightPos[] = {3, 3};
        int targetPos[] = {2, 1};
        int n = 3;
        System.out.println(sbk.minStepToReachTarget(knightPos, targetPos, n));
    }

    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int minSteps = Integer.MAX_VALUE;
        boolean[][] vis = new boolean[n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(knightPos[0] - 1, knightPos[1] - 1, 0));
        vis[knightPos[0] - 1][knightPos[1] - 1] = true;

        int[] r = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] c = {1, 2, 2, 1, -1, -2, -2, -1};

        while (!queue.isEmpty()) {

            Pair p = queue.poll();
            int row = p.r;
            int col = p.c;
            int step = p.time;

            if (row == targetPos[0] - 1 && col == targetPos[1] - 1) {
                minSteps = Integer.min(step, minSteps);
                // continue;
            } else {

                for (int i = 0; i < 8; i++) {

                    int nr = row + r[i];
                    int nc = col + c[i];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                        if (vis[nr][nc] == false) {
                            vis[nr][nc] = true;
                            if (nr == targetPos[0] - 1 && nc == targetPos[1] - 1) {
                                return step + 1;
                            }
                            queue.add(new Pair(nr, nc, step + 1));

                        }

                    }

                }

            }
        }

        return minSteps;

    }
}

/*
class Pairs{

    int r;
    int c;
    int s;

    Pairs(int r, int c, int s){
        this.r = r;
        this.c = c;
        this.s = s;
    }

}*/
