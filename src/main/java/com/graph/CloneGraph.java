package com.graph;

import java.util.*;

public class CloneGraph {

    public static void main(String[] args) {


    }


    public Node6 cloneGraph(Node6 node) {
        if (node == null) {
            return node;
        }
        HashMap<Node6, Node6> map = new HashMap<Node6, Node6>();

        dfs(map, node);
        bfs(map, node);

        return map.get(node);

    }

    void dfs(HashMap<Node6, Node6> map, Node6 oldP) {
        if (map.containsKey(oldP)) {
            return;
        }

        Node6 newP = new Node6(oldP.val, new ArrayList<>());
        map.put(oldP, newP);

        for (Node6 n : oldP.neighbors) {
            dfs(map, n);
            newP.neighbors.add(map.get(n));
        }
    }


    void bfs(HashMap<Node6,Node6> map, Node6 node){

        Queue<Node6> queue = new LinkedList<>();

        Node6 cloneStart = new Node6(node.val, new ArrayList<>());
        map.put(node, cloneStart);
        queue.offer(node);

        while (!queue.isEmpty()) {
            Node6 oldP = queue.poll();
            Node6 newP = map.get(oldP);

            for (Node6 nei : oldP.neighbors) {

                // if neighbor not cloned yet, clone + enqueue
                if (!map.containsKey(nei)) {
                    Node6 temp = new Node6(nei.val, new ArrayList<>());
                    map.put(nei, temp);
                    newP.neighbors.add(temp);
                    queue.offer(nei);
                }else {
                    Node6 temp = map.get(nei);
                    newP.neighbors.add(temp);
                }

            }
        }
    }


    class Node6 {
        public int val;
        public List<Node6> neighbors;

        public Node6() {
            val = 0;
            neighbors = new ArrayList<Node6>();
        }

        public Node6(int _val) {
            val = _val;
            neighbors = new ArrayList<Node6>();
        }

        public Node6(int _val, ArrayList<Node6> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

    }

}