package com.graph;

import java.util.*;

public class BFS {


    //BFS OWN

    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,3,4);
        addEdge(adj,2,4);

        System.out.println("Following is Breadth First Traversal: ");
        bfs(adj,0);
    }

    static List<Integer> bfs(ArrayList<ArrayList<Integer>> al, int startIndex) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] array = new boolean[al.size()];
        queue.add(startIndex);
        List<Integer> finalList = new ArrayList<>();

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


    static List<Integer> bfsWithNoStart(ArrayList<List<Integer>> al) {

        boolean[] array = new boolean[al.size()];

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < al.size(); i++) {
            if (!array[i]) {
                bfs(al, i, array, finalList);
            }
        }

        return finalList;
    }


    static List<Integer> bfs(ArrayList<List<Integer>> al, int startIndex, boolean[] array, List<Integer> finalList) {

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


    //BFS GeeksForGeeks

   /*static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    static void BFS(ArrayList<ArrayList<Integer>> adj,int V,int s)
    {
        boolean[] visited=new boolean[V];
        for(int i = 0; i < V; i++)
            visited[i] = false;

        Queue<Integer> q=new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while(q.isEmpty()==false)
        {
            int u = q.poll();
            System.out.print(u + " ");

            for(int v:adj.get(u)){
                if(visited[v]==false){
                    visited[v]=true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        int V = 5;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,0,2);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,1,3);
        addEdge(adj,3,4);
        addEdge(adj,2,4);

        System.out.println("Following is Breadth First Traversal: ");
        BFS(adj,V,0);
    }*/
}
