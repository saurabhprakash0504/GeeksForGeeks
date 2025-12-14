package com.graph;

import java.util.*;

public class PrintPathInDikstraAlgo {

    public static void main(String[] args) {

        PrintPathInDikstraAlgo ppda = new PrintPathInDikstraAlgo();
        int n = 5;
        int m = 6;
        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        List<Integer> res = ppda.shortestPath(n, m, edges);
        System.out.println(res);
    }

    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        //  Code Here.
        int[] parent = new int[n+1];
        int[] minDis = new int[n+1];
        ArrayList<Integer> finalList = new ArrayList<Integer>();

        Arrays.fill(minDis, Integer.MAX_VALUE);

        ArrayList<ArrayList<GraphPair>> al = new ArrayList<>();
        createAdjList(n, m, edges, al);

        parent[1]=1;
        minDis[1]=0;
        PriorityQueue<GraphPair> pq = new PriorityQueue<>((a, b) -> a.dis - b.dis);

        pq.add(new GraphPair(1, 0));

        while(!pq.isEmpty()){
            GraphPair poll = pq.poll();
            int to = poll.to;
            int dis = poll.dis;

            ArrayList<GraphPair> list = al.get(to);

            for(GraphPair adjacent : list){

                int adjTo = adjacent.to;
                int adjDis = adjacent.dis;

                if(minDis[adjTo] > dis+adjDis){
                    minDis[adjTo] = dis+adjDis;
                    parent[adjTo] = to;
                    pq.add(new GraphPair(adjTo, dis+adjDis));
                }

            }
        }

        //  System.out.println(Arrays.toString(minDis));

        if(minDis[n] == Integer.MAX_VALUE){
            finalList.add(-1);
            return finalList;
        }else{

            finalList.add(n);
            int i=n;
            while(parent[i] != i){
                finalList.add(parent[i]);
                i=parent[i];
            }
            Collections.reverse(finalList);
            finalList.add(0, minDis[n]);
        }

        return finalList;

    }


    void createAdjList(int vertex, int edge, int[][] edges,ArrayList<ArrayList<GraphPair>> al){
        for(int i=0;i<vertex+1;i++){
            al.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            al.get(edges[i][0]).add(new GraphPair(edges[i][1],edges[i][2]));
            al.get(edges[i][1]).add(new GraphPair(edges[i][0],edges[i][2]));
        }
    }
}

class GraphPair{

    int to;
    int dis;

    GraphPair(int t, int d){
        this.to=t;
        this.dis =d;
    }
}