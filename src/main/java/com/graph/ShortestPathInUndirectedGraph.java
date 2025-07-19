package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 2, 4);

        ArrayList<Integer> list = shortestPath(adj, 0);

        System.out.println(list);

    }


    static void addEdge(ArrayList<ArrayList<Integer>> al, int start, int end) {
        al.get(start).add(end);
    }

    static ArrayList<Integer> shortestPath(ArrayList<ArrayList<Integer>> al, int start) {
        ArrayList<Integer> finalList = new ArrayList<>();
        boolean[] array = new boolean[al.size()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        array[start] = true;
        finalList.add(start, 0);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            ArrayList<Integer> a = al.get(val);
            for (int i = 0; i < a.size(); i++) {
                int j = al.get(val).get(i);
                if (!array[j]) {
                    queue.add(j);
                    array[j] = true;
                    finalList.add(j, finalList.get(val) + 1);

                }
            }
        }

        return finalList;

    }

}
