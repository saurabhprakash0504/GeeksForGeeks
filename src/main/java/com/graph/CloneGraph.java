package com.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {

    public static void main(String[] args) {

        

    }

    public Node6 cloneGraph(Node6 node) {

        if(node == null){
            return node;
        }

        HashMap<Node6, Node6> oldToNew = new HashMap<Node6,Node6>();

        if(!oldToNew.containsKey(node)){

            Node6 newNode = new Node6(node.val, new ArrayList<Node6>());
            oldToNew.put(node, newNode);

            dfs(node, oldToNew);



        }



        return  oldToNew.get(node);

    }

    void dfs(Node6 old, HashMap<Node6, Node6> oldToNew){

        Node6 newNode = oldToNew.get(old);

        List<Node6> oldNeighbors = old.neighbors;
        for(Node6 oldN : oldNeighbors){
            if(!oldToNew.containsKey(oldN)){

                Node6 newN = new Node6(oldN.val, new ArrayList<>());
                oldToNew.put(oldN, newN);
                newNode.neighbors.add(newN);
                dfs(oldN, oldToNew);


            }else {

                Node6 newN = oldToNew.get(oldN);

                newNode.neighbors.add(newN);
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
