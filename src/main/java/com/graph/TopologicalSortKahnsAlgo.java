package com.graph;

import java.util.*;

public class TopologicalSortKahnsAlgo {

    public static void main(String[] args) {

        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};

        ArrayList<Integer> list = topoSort(4, edges);
        System.out.println(list);
    }


    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        HashMap<Integer, Integer> map = new HashMap<>(V);
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            map.put(i, 0);
            list.add(i, new ArrayList());
        }


        for (int i = 0; i < edges.length; i++) {
            int val = map.get(edges[i][1]);
            map.put(edges[i][1], val + 1);
            ArrayList<Integer> l = list.get(edges[i][0]);
            l.add(edges[i][1]);

        }

       /* for(Map.Entry<Integer,Integer> m : map.entrySet()){
            System.out.println("key << "+ m.getKey());
             System.out.println("value << "+ m.getValue());

        }*/

        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 0; i < V; i++) {
            if (map.get(i) == 0) {
                queue.add(i);
            }
        }

        // System.out.println("queue << "+ queue);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            al.add(p);
            ArrayList<Integer> w = list.get(p);
            for (int i = 0; i < w.size(); i++) {
                int k = map.get(w.get(i));
                k = k - 1;
                map.put(w.get(i), k);
                if (k == 0) {
                    queue.add(w.get(i));
                }
            }


        }
        return al;

    }
}
