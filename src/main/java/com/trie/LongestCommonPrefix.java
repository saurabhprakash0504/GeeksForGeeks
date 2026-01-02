package com.trie;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String arr[] = {"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix(arr)); // Output: "fl"

    }

    public String longestCommonPrefix(String arr[]) {
        // code here
        TrieNodeee root = new TrieNodeee();
        for (String s : arr) {
            insert(s, root, 0);
        }

        return find(root, "", 0);
    }

    String find(TrieNodeee root, String prefix, int ind) {
        // System.out.println("root total >> "+ root.totalChar);
        if (root.isEnd == true) {
            return prefix;
        }

        if (root.totalChar != 1) {
            return prefix;
        }
           /* prefix = prefix + s.charAt(ind);

            return find(root, prefix, ind+1, s);*/

        // find the only child
        int next = -1;
        for (int i = 0; i < 26; i++) {
            if (root.character[i] != null) {
                next = i;
                break;
            }
        }

        // append that character
        char c = (char) (next + 'a');
        prefix += c;

        // move to the child
        return find(root.character[next], prefix, ind + 1);

    }


    void insert(String s, TrieNodeee root, int ind) {
        if (s.length() == ind) {
            root.isEnd = true;
            return;
        }

        char c = s.charAt(ind);
        int i = c - 'a';
        if (root.character[i] == null) {
            TrieNodeee temp = new TrieNodeee();
            root.totalChar++;
            root.character[i] = temp;
            insert(s, temp, ind + 1);
        } else {
            //  TrieNode temp = root.character[i];
            //    root.character[i] = temp;
            insert(s, root.character[i], ind + 1);
        }
    }
}


class TrieNodeee {
    TrieNodeee[] character;
    int totalChar;
    boolean isEnd;

    TrieNodeee() {
        character = new TrieNodeee[26];
        totalChar = 0;
        isEnd = false;
    }

}
