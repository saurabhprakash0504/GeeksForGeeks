package com.trie;

import java.util.ArrayList;

public class PhoneDirectory {

    public static void main(String[] args) {

        String[] contact = {"geeikistest", "geeksforgeeks", "geeksfortest"};
        String s = "geeips";
        ArrayList<ArrayList<String>> result = displayContacts(contact.length, contact, s);
        for (ArrayList<String> list : result) {
            System.out.println(list);
        }

    }

    static ArrayList<ArrayList<String>> displayContacts(int n, String contact[],
                                                        String s) {
        ArrayList<ArrayList<String>> finalList = new ArrayList<>();
        TrieNodes root = new TrieNodes();
        for (String con : contact) {
            char[] arr = con.toCharArray();
            insert(arr, root, 0);
        }

        search(s, finalList, root, "");

        return finalList;
    }


    static void printSuggestions(TrieNodes curr, String prev, ArrayList<String> temp) {
        if (curr.isEnd == true) {
            temp.add(prev);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            TrieNodes next = curr.character[ch - 'a'];

            if (next != null) {
                prev = prev + ch;
                printSuggestions(next, prev, temp);
                prev = prev.substring(0, prev.length() - 1);
            }
        }

    }


    static void search(String s, ArrayList<ArrayList<String>> finalList, TrieNodes prevNode, String prev) {

        for (int i = 0; i < s.length(); i++) {
            char lastch = s.charAt(i);
            prev = prev + lastch;
            int ind = lastch - 'a';
            TrieNodes[] curr = prevNode.character;
            if (curr[ind] != null) {
                ArrayList<String> temp = new ArrayList<String>();
                printSuggestions(curr[ind], prev, temp);

                finalList.add(temp);
                temp = null;
                prevNode = curr[ind];

            } else {
                while (i < s.length()) {
                    ArrayList<String> temp = new ArrayList<>();
                    temp.add("0");
                    finalList.add(temp);
                    i++;
                }
                break;
            }
        }

    }


    static void insert(char[] arr, TrieNodes root, int i) {
        if (i == arr.length) {
            root.isEnd = true;
            return;
        }

        char c = arr[i];
        int ind = c - 'a';
        TrieNodes[] curr = root.character;
        if (curr[ind] == null) {
            curr[ind] = new TrieNodes();
            insert(arr, curr[ind], i + 1);
        } else {
            insert(arr, curr[ind], i + 1);
        }

    }
}

class TrieNodes {

    TrieNodes[] character;
    boolean isEnd;

    TrieNodes() {
        character = new TrieNodes[26];
        isEnd = false;
    }
}

