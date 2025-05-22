package com.tree;

import java.util.*;

public class SerializeAndDeserialize {

    public static void main(String[] args) {
        Node tree = new Node(1);
        tree.left = new Node(2);
        tree.right = new Node(3);
    /*    tree.left.left = new Node(6);
        tree.left.right = new Node(7);

        tree.right.right = new Node(8);
        tree.right.right.left = new Node(9);
        tree.right.right.left.left = new Node(10);*/

/*        Node tree = new Node(1);
        tree.left = new Node(6);
        tree.left.left = new Node(6);*/

        ArrayList<Integer> al = serialize(tree);

        System.out.println(al);

        Node root = deSerialize(al);

        System.out.println("root >> " + root);

    }

    public static ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> al = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp != null) {
                al.add(temp.data);
                queue.add(temp.left);
                queue.add(temp.right);
            } else {
                al.add(-1);
            }
        }
        return al;
    }

    // Function to deserialize a list and construct the tree.
    static Node deSerialize(ArrayList<Integer> arr) {
        Queue<Node> queue = new LinkedList<Node>();
        Node temp = new Node(arr.get(0));
        Node root = temp;
        Node curr = temp;
        Node prev = temp;
        int i = 1;
        queue.add(curr);
        while (i < arr.size()) {
            prev = queue.poll();
            if (arr.get(i) != -1) {
                curr = new Node(arr.get(i));
                prev.left = curr;
                queue.add(curr);
            } else {
                prev.left = null;
            }
            i++;
            if (i < arr.size()) {
                if (arr.get(i) != -1) {
                    curr = new Node(arr.get(i));
                    prev.right = curr;
                    queue.add(curr);
                } else {
                    prev.right = null;
                }
                i++;
            }

        }
        return root;
    }
}
