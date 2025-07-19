package com.graph;

import java.lang.reflect.Array;
import java.util.*;

public class DjkstraAlgo {


    public static void main(String[] args) {
        int V = 3;
        int src = 2;
        //int[][] edge = {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};

        int[][] edge = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};

        int[] ans = dijkstra(V, edge, src);

        System.out.println(Arrays.toString(ans));

    }

    public static int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        ArrayList<ArrayList<int[]>> al = new ArrayList<ArrayList<int[]>>();


        for (int i = 0; i < V; i++) {
            al.add(i, new ArrayList());
        }

        for (int i = 0; i < edges.length; i++) {
            ArrayList<int[]> l = al.get(edges[i][0]);
            int[] ab = {edges[i][1], edges[i][2]};
            l.add(ab);
            ArrayList<int[]> l2 = al.get(edges[i][1]);
            int[] ab2 = {edges[i][0], edges[i][2]};
            l2.add(ab2);
        }

        PriorityQueue<Sol> queue = new PriorityQueue<>((u, v) -> u.wt - v.wt);
        int[] arr = new int[V];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        arr[src] = 0;

        queue.add(new Sol(0, src));
        while (!queue.isEmpty()) {
            Sol curr = queue.poll();
            int wt = curr.wt;
            int node = curr.node;

            /*for(int i=0;i< edges.length;i++){
                if(edges[i][0] == node){
                    if(arr[edges[i][1]] > (edges[i][2] + wt)){
                        arr[edges[i][1]] = (edges[i][2] + wt);
                        queue.add(new Sol(edges[i][2] + wt, edges[i][1]));
                    }
                }else if( edges[i][1] == node){
                    if(arr[edges[i][0]] > (edges[i][2] + wt)){
                        arr[edges[i][0]] = (edges[i][2] + wt);
                        queue.add(new Sol(edges[i][2] + wt, edges[i][0]));
                    }
                }
            }*/

            ArrayList<int[]> l3 = al.get(node);
            for (int i = 0; i < l3.size(); i++) {
                if (arr[l3.get(i)[0]] > (l3.get(i)[1] + wt)) {
                    arr[l3.get(i)[0]] = (l3.get(i)[1] + wt);
                    queue.add(new Sol(l3.get(i)[1] + wt, l3.get(i)[0]));
                }
            }

        }

        return arr;
    }
}

class Sol {
    int wt;
    int node;

    Sol(int w, int n) {
        wt = w;
        node = n;
    }
}