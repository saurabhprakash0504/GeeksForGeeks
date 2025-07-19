package com.graph;

import java.util.*;

class AdjListNode {
    private int v;
    private int weight;

    AdjListNode(int _v, int _w) {
        v = _v;
        weight = _w;
    }

    int getV() {
        return v;
    }

    int getWeight() {
        return weight;
    }
}

class Graph {
    private int V;
    private ArrayList<ArrayList<AdjListNode>> adj;

    Graph(int v) {
        V = v;
        adj = new ArrayList();
        for (int i = 0; i < v; ++i)
            adj.add(i, new ArrayList());
    }

    void addEdge(int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        ArrayList<AdjListNode> a = adj.get(u);
        a.add(node);
        // adj.add(u, a.add(node));
    }

  /*  void topologicalSortUtil(int v, Boolean visited[], Stack stack) {

        visited[v] = true;
        Integer i;

        Iterator<AdjListNode> it = adj[v].iterator();
        while (it.hasNext()) {
            AdjListNode node = it.next();
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }

        stack.add(v);
    }

    void shortestPath(int s) {
        Stack stack = new Stack();
        int dist[] = new int[V];

        Boolean visited[] = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (stack.empty() == false) {
            int u = (int) stack.pop();

            Iterator<AdjListNode> it;
            if (dist[u] != Integer.MAX_VALUE) {
                it = adj[u].iterator();
                while (it.hasNext()) {
                    AdjListNode i = it.next();
                    if (dist[i.getV()] > dist[u] + i.getWeight())
                        dist[i.getV()] = dist[u] + i.getWeight();
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }*/


    void shortestPath(int s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> topological = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            ArrayList<AdjListNode> t = adj.get(i);

            for (AdjListNode a : t) {
                if (map.containsKey(a.getV())) {
                    int val = map.get(a.getV());
                    map.put(a.getV(), val + 1);
                } else {
                    map.put(a.getV(), 1);
                }
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty()) {
            int val = queue.poll();
            topological.add(val);
            ArrayList<AdjListNode> list = adj.get(val);

            for (AdjListNode a : list) {
                int v = map.get(a.getV());
                v = v - 1;
                map.put(a.getV(), v);
                if (v == 0) {
                    queue.add(a.getV());
                }
            }
        }

        System.out.println("top >> " + topological);

        int[] arr = new int[V];
        for (int i = 0; i < V; i++) {
            arr[i] = Integer.MAX_VALUE;
        }

        arr[s] = 0;

        for (int i : topological) {
            ArrayList<AdjListNode> a = adj.get(i);

            for (AdjListNode t : a) {
                if (arr[i] != Integer.MAX_VALUE) {
                    if (arr[t.getV()] > arr[i] + t.getWeight()) {
                        arr[t.getV()] = arr[i] + t.getWeight();
                    }
                }
            }
        }

        System.out.println(Arrays.toString(arr));


    }

}

class Main {
    public static void main(String args[]) {

       /* Graph g = new Graph(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);*/

        Graph g = new Graph(4);
        g.addEdge(0, 1, 5);
        g.addEdge(0, 2, 10);
        g.addEdge(2, 3, 2);
        g.addEdge(1, 3, 20);
        g.addEdge(1, 2, 3);


        int s = 0;
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }
}
