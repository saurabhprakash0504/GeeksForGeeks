package com.graph;

import java.util.ArrayList;

public class CreateAdjacencyList {

    public static void main(String[] args) {
        int v = 5;
        ArrayList<ArrayList<Integer>> al = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            al.add(new ArrayList<Integer>());
        }
        addInList(al, 3, 2);
        addInList(al, 3, 4);
        printing(al);
    }

    static void addInList(ArrayList<ArrayList<Integer>> al, int u, int v) {
        al.get(u).add(v);
        al.get(v).add(u);
    }

    static void printing(ArrayList<ArrayList<Integer>> al) {
        for (int i = 0; i < al.size(); i++) {
            System.out.print(i +" >> ");
            for (int j = 0; j < al.get(i).size(); j++) {
                System.out.print(al.get(i).get(j) + " , ");
            }
            System.out.println("");
        }

    }
}
