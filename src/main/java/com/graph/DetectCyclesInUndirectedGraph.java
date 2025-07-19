package com.graph;

import java.util.ArrayList;

public class DetectCyclesInUndirectedGraph {

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

        boolean answer = detectCycles(adj);

        System.out.println(answer);

    }


    static void addEdge(ArrayList<ArrayList<Integer>> al, int start, int end) {
        al.get(start).add(end);
    }


    public static boolean detectCycles(ArrayList<ArrayList<Integer>> al) {

        boolean[] arr = new boolean[al.size()];

        for (int i = 0; i < al.size(); i++) {
            if (!arr[i]) {
                if (detectCycleWithStartIndex(al, i, -1, arr)) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean detectCycleWithStartIndex(ArrayList<ArrayList<Integer>> al, int startIndex, int parent, boolean[] arr) {
        arr[startIndex] = true;
        for (int i = 0; i < al.get(startIndex).size(); i++) {
            if (!arr[al.get(startIndex).get(i)]) {
                if (detectCycleWithStartIndex(al, al.get(startIndex).get(i), startIndex, arr)) {
                    return true;
                }
            } else if (i != parent) {
                return true;
            }
        }
        return false;
    }

}
