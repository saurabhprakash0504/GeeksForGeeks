package com.graph;

import java.util.*;

public class CourseSchedule2 {

    public static void main(String[] args) {

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};

        CourseSchedule2 obj = new CourseSchedule2();
        int[] res = obj.findOrder(numCourses, prerequisites);
        System.out.println(Arrays.toString(res));

    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(i, new ArrayList<>());
        }
        //createAdjList
        createList(adj, prerequisites);
        int[] res = new int[numCourses];
        boolean[] vis = new boolean[numCourses];
        boolean[] dfsVis = new boolean[numCourses];
        //checkIsLoop

        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {
                boolean loop = isLoop(i, vis, dfsVis, adj);
                if (loop) {
                    int[] arr = {};
                    return arr;
                }
            }
        }


        //If no loop then find the topological order
        Stack<Integer> stack = new Stack<Integer>();
        vis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {

            if (!vis[i]) {
                dfs(i, vis, stack, adj);
            }
        }


        int i = 0;

        while (!stack.isEmpty()) {
            int val = stack.pop();
            res[i] = val;
            i++;
        }

        return res;


    }


    static boolean isLoop(int curr, boolean[] vis, boolean[] dfsVis, ArrayList<ArrayList<Integer>> adj) {

        vis[curr] = true;
        dfsVis[curr] = true;

        ArrayList<Integer> neigh = adj.get(curr);

        for (int i : neigh) {
            if (!vis[i]) {
                if (isLoop(i, vis, dfsVis, adj)) {
                    return true;
                }
            } else if (dfsVis[i]) {
                return true;
            }
        }
        dfsVis[curr] = false;

        return false;


    }

    static void dfs(int i, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {

        vis[i] = true;
        ArrayList<Integer> neigh = adj.get(i);

        for (int u : neigh) {
            if (!vis[u]) {
                dfs(u, vis, stack, adj);
            }
        }

        stack.push(i);

    }


    static void createList(ArrayList<ArrayList<Integer>> adj, int[][] prerequisites) {

        for (int i = 0; i < prerequisites.length; i++) {
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
        }
    }

}
