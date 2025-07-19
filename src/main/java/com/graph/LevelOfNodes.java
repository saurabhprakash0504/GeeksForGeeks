package com.graph;

import java.util.ArrayList;
import java.util.List;

public class LevelOfNodes {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(6);
        for (int i = 0; i < 6; i++) {
            adj.add(i, new ArrayList());
        }

        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        adj.set(0, a);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(3);
        b.add(4);
        adj.set(1, b);
        ArrayList<Integer> c = new ArrayList<>();
        c.add(5);
        adj.set(2, c);

        System.out.println(nodeLevel(6, adj, 4));
    }

    static int nodeLevel(int V, ArrayList<ArrayList<Integer>> nadj, int X) {
        // code here
        int count = 0;
      /*  for(int i=0;i< adj.size();i++){
            System.out.println(i +" >> " +adj.get(i));
        }*/

   /*     ArrayList<ArrayList<Integer>> nadj = new ArrayList<>(adj.size());
        for (int i = 0; i < adj.size(); i++) {
            nadj.add(i, new ArrayList());
        }

        boolean[] vis = new boolean[V];
        vis[0] = true;
        for (int i = 0; i < adj.size(); i++) {
            // vis[i] = true;
            ArrayList<Integer> l = adj.get(i);
            for (int j = 0; j < l.size(); j++) {
                if (!vis[l.get(j)]) {
                    nadj.get(i).add(l.get(j));
                    vis[l.get(j)] = true;
                }
            }
        }
*/
        /*  for(int i=0;i< nadj.size();i++){
            System.out.println(i +" >> " +nadj.get(i));
        }*/


       /* Queue<Integer> q = new LinkedList<Integer>();

        q.add(0);
        q.add(-1);

        while(!q.isEmpty()){
            Integer p = q.poll();
            if(p == -1){
                count++;
                continue;
            }
            if(p == X){
                return count;
            }
            ArrayList<Integer> al = nadj.get(p);
            for(int i=0;i< al.size();i++){
                q.add(al.get(i));
            }
            q.add(-1);
        }
        return -1;*/

        boolean[] vis1 = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis1[i]) {
                count = 0;
                dfs(i, vis1, nadj, X);
                if (found) {
                    return count;
                }
            }
        }
        return -1;
    }

    static int count = 0;
    static boolean found = false;

    static void dfs(int start, boolean[] vis, ArrayList<ArrayList<Integer>> nadj, int x) {
        if (start == x) {
            found = true;
            return;
        }
        vis[start] = true;
        if(!found)
            count++;
        for (int i = 0; i < nadj.get(start).size(); i++) {
            dfs(nadj.get(start).get(i), vis, nadj, x);
        }
    }
}
