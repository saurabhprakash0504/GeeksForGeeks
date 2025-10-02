package com.practice;

import java.util.ArrayList;

public class PermutationOfAString {

    public static void main(String[] args) {
        PermutationOfAString ps = new PermutationOfAString();
        ArrayList<String> res = ps.findPermutation("abc");
        System.out.println(res);
    }

    public ArrayList<String> findPermutation(String s) {

        ArrayList<String> list = new ArrayList<>();
        char[] arr = s.toCharArray();
        find(arr, 0, list);
        return list;
    }

    void find(char[] arr, int ind,ArrayList<String> list){

        if(ind == arr.length){
            list.add(String.valueOf(arr));
            return;
        }

        for(int i=ind;i<arr.length;i++){
            swap(arr, i, ind);
            find(arr, ind+1,list);
            swap(arr, i, ind);
        }

    }

    void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
