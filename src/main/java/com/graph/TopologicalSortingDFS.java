package com.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class TopologicalSortingDFS {


    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 3}, {2, 3}, {2,4}};

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            list.add(i, new ArrayList());
        }


        for (int i = 0; i < edges.length; i++) {
            ArrayList<Integer> l = list.get(edges[i][0]);
            l.add(edges[i][1]);
        }

        ArrayList<Integer> l = topological(list, 0);
        System.out.println(l);

    }

    static ArrayList<Integer> topological(ArrayList<ArrayList<Integer>> al, int start) {

        boolean[] visited = new boolean[al.size()];
        Stack<Integer> stack = new Stack<>();
        for (int i = start; i < al.size(); i++) {
            if (!visited[i]) {
                topological(al, i, visited, stack);
            }
        }
        ArrayList<Integer> l = new ArrayList<>();
        while (!stack.isEmpty()) {
            l.add(stack.pop());
        }

        return l;
    }

    static void topological(ArrayList<ArrayList<Integer>> al, int start, boolean[] visited, Stack<Integer> stack) {

        visited[start] = true;

        for (int i = 0; i < al.get(start).size(); i++) {
            int val = al.get(start).get(i);
            if (!visited[val]) {
                topological(al, val, visited, stack);
            }

        }
        stack.push(start);
    }
}
