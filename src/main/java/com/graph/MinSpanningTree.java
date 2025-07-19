package com.graph;

import java.util.*;

public class MinSpanningTree {

    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.

        PriorityQueue<Prism> queue = new PriorityQueue<>((x, y) -> x.wt - y.wt);
        boolean[] arr = new boolean[V];
        int sum = 0;
        ArrayList<ArrayList<Integer>> finalList = new ArrayList<>();

        queue.add(new Prism(0, 0, -1));
        while (!queue.isEmpty()) {
            Prism curr = queue.poll();
            if (arr[curr.node]) { //
                continue;
            } else {
                arr[curr.node] = true;
                sum = sum + curr.wt;
                ArrayList<Integer> l = new ArrayList<>();
                l.add(0, curr.node);
                l.add(1, curr.parent);
                finalList.add(l);

                List<int[]> lk = adj.get(curr.node);

                for (int j = 0; j < lk.size(); j++) {
                    if (arr[lk.get(j)[0]] == false) {
                        Prism p = new Prism(lk.get(j)[1], lk.get(j)[0], curr.node);
                        queue.add(p);
                    }
                }
            }
        }

        return sum;

    }
}


class Prism {

    int wt;
    int node;
    int parent;

    Prism(int w, int n, int p) {
        wt = w;
        node = n;
        parent = p;
    }
}