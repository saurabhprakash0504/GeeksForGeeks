package com.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CountingIsland {

    public static void main(String[] args)
    {
        int V = 7;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,4,5);
        addEdge(adj,5,6);
        addEdge(adj,4,6);

        System.out.println("Following is Breadth First Traversal: ");
        System.out.println("no of island >> "+ coutingIsland(adj));
    }

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static Integer coutingIsland(ArrayList<ArrayList<Integer>> al) {

        int count=0;
        boolean[] array = new boolean[al.size()];

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < al.size(); i++) {
            if (!array[i]) {
                count++;
                bfs(al, i, array, finalList);
            }
        }

        return count;
    }


    static List<Integer> bfs(ArrayList<ArrayList<Integer>> al, int startIndex, boolean[] array, List<Integer> finalList) {

        Queue<Integer> queue = new LinkedList<>();
        // boolean[] array = new boolean[al.size()];
        queue.add(startIndex);
        //  List<Integer> finalList = new ArrayList<>();

        while (!queue.isEmpty()) {

            Integer val = queue.poll();
            finalList.add(val);
            array[val] = true;

            List<Integer> l = al.get(val);

            for (Integer i : l) {
                if (!array[i] && !queue.contains(i)) {
                    queue.add(i);
                }
            }
        }
        return finalList;
    }


}
