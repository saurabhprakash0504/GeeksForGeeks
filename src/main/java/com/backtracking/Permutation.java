package com.backtracking;

import java.util.*;
import java.util.Arrays;

public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        ArrayList<String> l = p.findPermutation("abc");
        System.out.println(l);
    }

    public ArrayList<String> findPermutation(String s) {
        HashSet<String> al = new HashSet<String>();
        char[] c = s.toCharArray();
        findPerm(c, al, 0);
        ArrayList<String> l = new ArrayList<>(al);
        return l;
    }

    void findPerm(char[] c, HashSet<String> al, int i) {
        if (i == c.length) {
            al.add(new String(c));
            return;
        }

        for (int j = i; j < c.length; j++) {
            swap(c, i, j);
            findPerm(c, al, i + 1);
            swap(c, i, j);
        }
    }

    void swap(char[] c, int i, int j) {
        char cc = c[i];
        char d = c[j];
        c[i] = d;
        c[j] = cc;
    }
}
