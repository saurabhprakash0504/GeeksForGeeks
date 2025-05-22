package com.tree;

import java.util.*;

public class LCA {

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right = new Node(1);

        lca(root, 5, 4);
    }

   static Node lca(Node root, int n1, int n2) {
        // Your code here

        ArrayList<Node> l1 = new ArrayList<Node>();
        ArrayList<Node> l2 = new ArrayList<Node>();

        // System.out.println("value1 ");

        createList(root, n1, l1);
        // System.out.println("value2 ");
       flag = true;
        createList(root, n2, l2);

      /*  for(int i=0;i < l1.size();i++){
            System.out.println(l1.get(i).data);
        }

        System.out.println("value ");

        for(int i=0;i < l2.size();i++){
            System.out.println(l2.get(i).data);
        }*/


       Node prev1=null;
       if(l1.size()< l2.size()){
           for(int i=0;i<l1.size();i++){
               if(l1.get(i).data == l2.get(i).data){
                   prev1= l1.get(i);
               }else{
                 //  prev1= l1.get(i-1);
                   break;
               }
           }
       }else{
           for(int i=0;i<l2.size();i++){
               if(l1.get(i).data == l2.get(i).data){
                   prev1= l1.get(i);
                 //  continue;
               }else{
                  // prev1= l2.get(i-1);
                   break;
               }
           }
       }
        return prev1;
    }

  static   boolean flag = true;
  static   void createList(Node root, int val, ArrayList<Node> list){
        if(root == null){
            return;
        }

        list.add(root);

        if(root.data == val){
            flag = false;
            return;
        }


            createList(root.left, val, list);
            createList(root.right, val, list);
      if(flag) {
            list.remove(root);
        }
    }
}