package com.trie;

import java.util.HashSet;

public class CountOfDistinctSubStrings {

    public static void main(String[] args) {

        String str = "ababa";
        System.out.println(CountOfDistinctSubStrings.countSubs(str)); // Output: 10

    }

    public static int countSubs(String s) {
        // code here
        //return findIternative(s);

        TrieNode1 root = new TrieNode1();
        count = 0;
        for (int i = 0; i < s.length(); i++) {
            countDistinct(s, i, root);
        }

        return count;
    }

    static int count = 0;

    static int findIternative(String s) {
        HashSet<String> set = new HashSet<>();
        for (int len = 1; len <= s.length(); len++) {
            for (int j = 0; j < s.length(); j++) {
                if (j + len <= s.length()) {
                    set.add(s.substring(j, j + len));
                }
            }
        }
        // System.out.println("set "+ set);
        return set.size();
    }

    static void countDistinct(String s, int ind, TrieNode1 root) {

        if (ind == s.length()) {
            return;
        }

        char c = s.charAt(ind);

        int val = c - 'a';

        if (root.character[val] == null) {
            count++;
            TrieNode1 dummy = new TrieNode1();
            root.character[val] = dummy;
        }
        countDistinct(s, ind + 1, root.character[val]);

    }


}

class TrieNode1 {

    TrieNode1[] character;
    boolean isEnd;

    TrieNode1() {
        character = new TrieNode1[26];
        isEnd = false;
    }
}