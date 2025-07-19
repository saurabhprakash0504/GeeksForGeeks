package com.backtracking;

public class RatInAMaze {

    static int[][] sol = new int[3][3];

    public static void main(String[] args) {
        //  int[][] maze = {{1, 0, 0, 0}, {1, 1, 0, 1}, {0, 1, 0, 0}, {1, 1, 1, 1}};
        int[][] maze = {{1, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        sol[0][0] = 1;
        System.out.println(findPath(maze, 0, 0));

        for (int i = 0; i < sol.length; i++) {
            for (int j = 0; j < sol[0].length; j++) {
                System.out.print(sol[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean findPath(int[][] maze, int i, int j) {

        if (i == maze.length - 1 && j == maze[0].length - 1) {
            System.out.println("found");
            return true;
        }

        if (i >= maze.length || j >= maze.length) {
            System.out.println("couldnt find");
            return false;
        }

        if (isSafe(maze, sol, i + 1, j)) {
            findPath(maze, i + 1, j);
        } else if (isSafe(maze, sol, i, j + 1)) {
            findPath(maze, i, j + 1);
        }

        return false;
    }


    static boolean isSafe(int[][] maze, int[][] sol, int i, int j) {
        if (i < maze.length && j < maze[0].length && maze[i][j] == 1) {
            sol[i][j] = 1;
            return true;
        }
        return false;
    }
}
