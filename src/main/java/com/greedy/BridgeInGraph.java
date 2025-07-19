package com.greedy;

import java.util.*;

public class BridgeInGraph {

    public static void main(String[] args) {

    }

    int timer = 1;
    public boolean isBridge(int V, int[][] edges, int c, int d) {
        // code here

        ArrayList<ArrayList<Integer>> al = new ArrayList<>(V);
        ArrayList<ArrayList<Integer>> fl = new ArrayList<>(V);

        for(int i=0;i<V;i++){
            al.add(new ArrayList<>());
            fl.add(new ArrayList<>());
        }

        for(int i=0;i< edges.length;i++){
            int first = edges[i][0];
            int sec = edges[i][1];
            al.get(first).add(sec);
            al.get(sec).add(first);
        }


        int[] dis = new int[V];
        int[] min = new int[V];
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i])
                dfs(al, dis, min, vis, i,-1, fl );
        }

        ArrayList<Integer> a = fl.get(c);
        if(a.contains(d)){
            return true;
        }

        ArrayList<Integer> b = fl.get(d);
        if(b.contains(c)){
            return true;
        }

        return false;
    }


    void dfs(ArrayList<ArrayList<Integer>> al , int[] dis, int[] min , boolean[] vis, int start , int parent, ArrayList<ArrayList<Integer>> fl){
        vis[start] = true;
        dis[start] = timer;
        min[start] = timer;
        timer++;


        for(int i=0;i<al.get(start).size();i++){
            int ind = al.get(start).get(i);

            if(ind == parent){
                continue;
            }

            if(vis[ind]){
                //this checks backedge
                min[start] = Integer.min(min[start], dis[ind]);
            }else{

                dfs(al, dis, min, vis, ind, start, fl);

                min[start] = Integer.min(min[start], min[ind]);

                if(min[ind] > dis[start]){
                    fl.get(ind).add(start);
                    fl.get(start).add(ind);
                }

            }

        }

    }
}
