package com.trie;

public class TrieOperations {


    public static void main(String[] args) {
        TrieOperations trie = new TrieOperations();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.isPrefix("app"));   // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }

    TrieNode root;

    public TrieOperations() {
        // Implement Trie
        root = new TrieNode();
    }

    // Insert a word into the Trie
    void insertUtil(TrieNode root, String word) {
        if (word.length() == 0) {
            root.isEnd = true;
            return;
        }

        int ind = word.charAt(0) - 'a';
        if (root.array[ind] == null) {
            root.array[ind] = new TrieNode();
        }
        insertUtil(root.array[ind], word.substring(1));

    }

    public void insert(String word) {

        insertUtil(root, word);

    }

    boolean searchUtil(TrieNode root, String word) {
        if (word.length() == 0) {
            //root.isEnd = true;
            return root.isEnd;
        }

        int ind = word.charAt(0) - 'a';
        if (root.array[ind] == null) {
            return false;
        }

        return searchUtil(root.array[ind], word.substring(1));
    }

    // Search for a word in the Trie
    public boolean search(String word) {

        return searchUtil(root, word);

    }

    boolean isPrefix(TrieNode root, String word) {
        if (word.length() == 0) {
            //root.isEnd = true;
            return true;
        }

        int ind = word.charAt(0) - 'a';
        if (root.array[ind] == null) {
            return false;
        }

        return isPrefix(root.array[ind], word.substring(1));
    }

    // Check if a prefix exists in the Trie
    public boolean isPrefix(String word) {
        return isPrefix(root, word);
    }
}
