package com.graph;

import java.util.ArrayList;

public class DFS {

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj, 0, 1);
        addEdge(adj, 0, 2);
     //   addEdge(adj, 1, 2);
        addEdge(adj, 2, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 3, 4);
        addEdge(adj, 1, 4);

        System.out.println("Following is Breadth First Traversal: ");
        ArrayList<Integer> l = dfs(adj);
        System.out.println(l);
    }

    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> al) {

        boolean[] visited = new boolean[al.size()];

        ArrayList<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < al.size(); i++) {
            if (!visited[i])
                dfsTraversal(al, i, visited, finalList);
        }

        return finalList;


    }

    static void dfsTraversal(ArrayList<ArrayList<Integer>> al, int startIndex, boolean[] visited, ArrayList<Integer> finalList) {

        finalList.add(startIndex);
        visited[startIndex] = true;

        for (int i = 0; i < al.get(startIndex).size(); i++) {
            if (!visited[al.get(startIndex).get(i)]) {
                dfsTraversal(al, al.get(startIndex).get(i), visited, finalList);
            }
        }
    }

}
