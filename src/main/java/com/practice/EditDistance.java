package com.practice;

public class EditDistance {

    public static void main(String[] args) {

        String s1 = "mdl";
        String s2 = "qhszmmbgi";

        EditDistance obj = new EditDistance();
        System.out.println(obj.editDistance(s1, s2));
    }

    public int editDistance(String s1, String s2) {
        // Code here
        return find(s1, s2,0, 0);
    }

    int find(String s1, String s2, int i1, int i2){

        if(i1 == s1.length()){
            return (s2.length()-1)-i2;
        }

        if(i2 == s2.length()){
            return (s1.length()-1)-i1;
        }

        if(s1.charAt(i1)== s2.charAt(i2)){
            return find(s1,s2,i1+1,i2+1);
        }else {

            int insert = 1 + find(s1, s2, i1, i2 + 1);
            int remove = 1 + find(s1, s2, i1 + 1, i2);
            int replace = 1 + find(s1, s2, i1 + 1, i2 + 1);

            return Integer.min(insert, Integer.min(remove, replace));

        }

    }
}
