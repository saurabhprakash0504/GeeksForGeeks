package com.trie;

public class ShortestPrefixForEveryWord {

    public static void main(String[] args) {
        String[] arr = {"zebra", "dog", "duck", "dove"};
        int N = arr.length;
        String[] res = findPrefixes(arr, N);
        for(String s : res){
            System.out.println(s);
        }
    }
    static String[] findPrefixes(String[] arr, int N) {
        // code here
        TrieNodess root = new TrieNodess();
        String[] res = new String[N];

        for(String s : arr){
            insert(s, N, root, 0);
        }

        for(int i=0;i< arr.length;i++){
            String prefix = "";
            String r = search(arr[i], N, root,0, prefix);
            res[i]= r;
        }

        return res;
    }


    static String search(String s, int n, TrieNodess root,  int ind, String prefix){

        if(root.freq == 1 || root.isEnd == true){
            return prefix;
        }

        char c = s.charAt(ind);
        prefix = prefix + c;

        int i = c - 'a';

        return search(s, n, root.character[i], ind+1, prefix);
    }


    static void insert(String s, int n, TrieNodess root, int ind){

        if(ind == s.length()){
            root.isEnd = true;
            return;
        }

        char c = s.charAt(ind);
        int i = c - 'a';
        if(root.character[i] == null){
            TrieNodess temp = new TrieNodess();
            temp.freq =1;
            root.character[i] = temp;
            insert(s, n, temp, ind+1);
        }else{
            TrieNodess temp = root.character[i];
            int f = temp.freq;
            temp.freq = f+1;
            root.character[i] = temp;
            insert(s, n, temp, ind+1);
        }

    }

};

class TrieNodess{

    TrieNodess[] character;
    int freq;
    boolean isEnd;

    TrieNodess(){
        character = new TrieNodess[26];
        freq = 0;
        isEnd = false;
    }

}