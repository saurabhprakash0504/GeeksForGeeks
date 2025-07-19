package com.graph;

import java.util.ArrayList;

public class DetectCyclesInDirectedGraph {

    public static void main(String[] args) {
        int v = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1);
        //  addEdge(adj, 0, 2);
        addEdge(adj, 1, 2);
      //  addEdge(adj, 2, 1);
        addEdge(adj, 2, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 4, 5);
      //  addEdge(adj, 5, 1);

        boolean answer = detectCyclesInDirectedGraph(adj, 0);

        System.out.println(answer);

    }


    static void addEdge(ArrayList<ArrayList<Integer>> al, int start, int end) {
        al.get(start).add(end);
    }

    static boolean detectCyclesInDirectedGraph(ArrayList<ArrayList<Integer>> al, int start) {

        boolean[] visitedArray = new boolean[al.size()];

        boolean flag = false;
        for (int i = 0; i < al.size(); i++) {
            if (!visitedArray[i]) {
                boolean[] recTraversal = new boolean[al.size()];
                if (detectCyclesInDirectedGraph2(al, i, visitedArray, recTraversal)) {
                    flag = true;
                    break;
                }
            }
        }
        return flag;
    }

    static boolean detectCyclesInDirectedGraph2(ArrayList<ArrayList<Integer>> al, int start, boolean[] visitedArray, boolean[] recTraversal) {

        visitedArray[start] = true;
        recTraversal[start] = true;
        for (int i = 0; i < al.get(start).size(); i++) {
            int val = al.get(start).get(i);
            if (!visitedArray[val]) {
                visitedArray[val] = true;
                recTraversal[val] = true;
                if (detectCyclesInDirectedGraph2(al, val, visitedArray, recTraversal)) {
                    return true;
                }
            } else if (recTraversal[val]) {
                return true;
            }
        }
        return false;
    }
}
