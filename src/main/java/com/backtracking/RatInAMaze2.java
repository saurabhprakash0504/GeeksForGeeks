package com.backtracking;

import java.util.ArrayList;

public class RatInAMaze2 {

    public static void main(String[] args) {
        int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {1, 1, 0, 0}, {0, 1, 1, 1}};

        System.out.println(ratInMaze(maze));
    }

    // Function to find all possible paths
  static int[][] sol;

    public static ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        int r = maze.length;
        int c = maze[0].length;
        sol = new int[r][c];
        //   ArrayList<String> fl = new ArrayList<String>();

        check(maze, "", 0, 0, r-1, c-1);

        return fl;

    }

   static ArrayList<String> fl = new ArrayList<>();

   static void check(int[][] maze, String s, int i, int j, int r, int c) {

        if (i == r && j == c) {
            fl.add(s);
        }

        if (i > r || j > c) {
            return;
        }

       if (isSafe(maze, i, j + 1)) {
           s = s + "R";
           check(maze, s, i, j + 1, r, c);
       }
       else if (isSafe(maze, i + 1, j)) {
            s = s + "D";
            check(maze, s, i + 1, j, r, c);
        }/* else if (isSafe(maze, i - 1, j)) {
            s = s + "L";
            check(maze, s, i - 1, j, r, c);
        } else if (isSafe(maze, i, j + 1)) {
            s = s + "D";
            check(maze, s, i, j + 1, r, c);
        } else if (isSafe(maze, i, j - 1)) {
            s = s + "U";
            check(maze, s, i, j - 1, r, c);
        }*/
        return;
    }

   static boolean isSafe(int[][] maze, int i, int j) {
        if (i < maze.length && j < maze[0].length && maze[i][j] == 1) {
            return true;
        }
        return false;
    }


}
