package com.greedy;

import java.util.ArrayList;
import java.util.Set;
import java.util.*;

public class ArticulationPoint {

    public static void main(String[] args) {

    }

    int timer =1;
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        //Different than Bridges
        int child =0;

        TreeSet<Integer> fl = new TreeSet<Integer>();
        int[] dis = new int[V];
        int[] min = new int[V];
        boolean[] vis = new boolean[V];

        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj, dis, min, vis, i, -1, fl);
            }
        }
        if(fl.size() == 0){
            return new ArrayList<>(List.of(-1));
        }

        return new ArrayList<>(fl);
    }

    void dfs(ArrayList<ArrayList<Integer>> adj, int[] dis, int[] min, boolean[] vis, int start, int parent, TreeSet<Integer> fl){
        vis[start] = true;
        dis[start]= timer;
        min[start] = timer;
        timer++;
        int child = 0;

        for(int i=0;i<adj.get(start).size();i++){
            int id = adj.get(start).get(i);
            if(id == parent){
                continue;
            }
            if(vis[id]){
                min[start]= Integer.min(min[start],dis[id]);
            }else{
                child++;
                dfs(adj, dis, min, vis, id, start, fl);

                min[start] = Integer.min(min[start], min[id]);
                //Different than Bridges
                if(parent !=-1 && min[id] >= dis[start]){
                    fl.add(start);
                }
            }
        }
        //Different than Bridges
        if(parent == -1 && child > 1){
            fl.add(start);
        }
    }
}