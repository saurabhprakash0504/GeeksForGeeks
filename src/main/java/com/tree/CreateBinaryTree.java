package com.tree;

public class CreateBinaryTree {



    int count = 0;

    Node createTree(int[] arr) {
      if (count > arr.length || arr[count] == -1) {
            return null;
        }
        Node newNode = new Node(arr[count]);
        count++;
        newNode.left = createTree(arr);
        newNode.right = createTree(arr);
        return newNode;


          /*    if(nodes[count] == -1) {
                return null;
            }
        count++;
            Node newNode = new Node(nodes[count]);
            newNode.left = createTree(nodes);
            newNode.right = createTree(nodes);
            return newNode;*/
        }




    public static void main(String[] args) {

        int[] arr = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};

        CreateBinaryTree createBinaryTree = new CreateBinaryTree();

        Node root = createBinaryTree.createTree(arr);

        System.out.println(root.data);

    }



}
