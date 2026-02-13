package com.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0;
        int dst = 2;
        int k = 1;

        int answer = findCheapestPrice(n, flights, src, dst, k);
        System.out.println(answer);
    }

    public static int findCheapestPrice(int nn, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Node>> adj = new ArrayList<>();
        for (int i = 0; i < nn; i++) {
            adj.add(new ArrayList<Node>());
        }
        createList(adj, flights);
        int[] dis = new int[nn];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.stop - b.stop);

        //  Queue<Node> q = new LinkedList<>();

        q.add(new Node(src, 0, 0));
        dis[src] = 0;

        while (!q.isEmpty()) {

            Node p = q.poll();

            int to = p.src;
            int pr = p.cost;
            int st = p.stop;

            if (st > k) {
                continue;
            }

            ArrayList<Node> neigh = adj.get(to);

            for (Node n : neigh) {
                int tt = n.src;
                int childPrice = n.cost;
                int st1 = n.stop;

                //  if(st <= k && dis[tt] > dis[to] + childPrice){

                if (st <= k && dis[tt] > childPrice + pr) {

                    //dis[tt] = dis[to] + childPrice;

                    dis[tt] = childPrice + pr;

                    q.add(new Node(tt, dis[tt], st + 1));
                }


            }
        }
        if (dis[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dis[dst];
    }


    static void createList(ArrayList<ArrayList<Node>> adj, int[][] flights) {

        for (int i = 0; i < flights.length; i++) {
            int from = flights[i][0];
            int to = flights[i][1];
            int price = flights[i][2];

            adj.get(from).add(new Node(to, price, 0));
        }

    }
}


class Node {

    int src;
    int cost;
    int stop;

    Node(int sr, int c, int s) {
        src = sr;
        cost = c;
        stop = s;
    }
}
