package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class ShortestPathInUndirectedGraph {

    public static void main(String[] args) {

        int v = 3;
        int src = 2;
        int[][] edges = {{0, 1, 1}, {1, 2, 3}, {0, 2, 6}};

        ShortestPathInUndirectedGraph spg = new ShortestPathInUndirectedGraph();
        int[] ans = spg.dijkstra(v, edges, src);

        System.out.println(Arrays.toString(ans));

    }

    public int[] dijkstra(int v, int[][] edges, int src) {

        ArrayList<ArrayList<Pair>> adjList = new ArrayList<ArrayList<Pair>>();
        convertToAdjacencyList(edges, v, adjList);

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.wt - b.wt);


        int[] shortPath = new int[v];

        findShortestPath( v, adjList, pq, shortPath, src);
        return shortPath;
    }

    public void findShortestPath(int v, ArrayList<ArrayList<Pair>> adjList ,
                                 PriorityQueue<Pair> pq, int[] shortPath, int src){

        Arrays.fill(shortPath, Integer.MAX_VALUE);
        shortPath[src] = 0;
        pq.add(new Pair(src, 0));
        while(!pq.isEmpty()){

            Pair pair = pq.poll();
            int to = pair.to;
            int wt = pair.wt;

            ArrayList<Pair> pairs = adjList.get(to);

            for(int i=0;i<pairs.size();i++){
                Pair p= pairs.get(i);
                int t = p.to;
                int w = p.wt;

                if(shortPath[t] > w+shortPath[to]){
                    shortPath[t] = w+shortPath[to];
                    pq.add(new Pair(t, w+shortPath[to]));
                }
            }

        }


    }

    public void convertToAdjacencyList(int[][] edges, int v, ArrayList<ArrayList<Pair>> adjList){

        for(int i=0;i<v;i++){
            adjList.add(new ArrayList<Pair>());
        }

        for(int i=0;i<edges.length;i++){
            int from = edges[i][0];
            int to = edges[i][1];
            int wt = edges[i][2];

            adjList.get(from).add(new Pair(to,wt));
            adjList.get(to).add(new Pair(from,wt));
        }
    }
}


class Pair{

    int to;
    int wt;

    Pair(int to, int wt){
        this.to = to;
        this.wt = wt;
    }

}

