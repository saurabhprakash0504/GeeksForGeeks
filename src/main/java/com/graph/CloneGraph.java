package com.graph;

import java.util.*;

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


    //BFS


    /*Node6 cloneGraph(Node6 node) {


        // code here
        if(node == null){
            return node;
        }

        Node6 head = node;

        HashMap<Node6,Node6> oldNewMap = new HashMap<>();
        Queue<Node6> q = new LinkedList<>();
        // Node newNode = new Node(node.val);
        q.add(node);
        while(!q.isEmpty()){

            Node6 oldNode = q.poll();
            if(oldNewMap.containsKey(oldNode)){
                Node6 newNode = oldNewMap.get(oldNode);
                List<Node6> oldNeighbors = oldNode.neighbors;
                for(Node6 oldN :oldNeighbors){
                    if(!oldNewMap.containsKey(oldN)){
                        Node6 newP = new Node6(oldN.val);
                        oldNewMap.put(oldN, newP);
                        q.add(oldN);
                        newNode.neighbors.add(newP);
                    }else{
                        Node6 newChild = oldNewMap.get(oldN);
                        newNode.neighbors.add(newChild);
                    }
                }
            }else{
                Node6 newN = new Node6(oldNode.val);
                oldNewMap.put(oldNode, newN);
                List<Node6> oldNeighbors = oldNode.neighbors;
                for(Node6 oldN :oldNeighbors){
                    if(!oldNewMap.containsKey(oldN)){
                        Node6 newP = new Node6(oldN.val);
                        oldNewMap.put(oldN, newP);
                        q.add(oldN);
                        newN.neighbors.add(newP);
                    }else{
                        Node6 newChild = oldNewMap.get(oldN);
                        newN.neighbors.add(newChild);
                    }
                }
            }
        }

        // System.out.println("size >> "+ oldNewMap.size());
        // System.out.println("val >> "+ oldNewMap.get(node.val).val);
        // System.out.println("size >> "+ oldNewMap.get(node.val).neighbors);

        return    oldNewMap.get(node);
    }*/
}
