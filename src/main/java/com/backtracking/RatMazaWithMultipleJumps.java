package com.backtracking;

public class RatMazaWithMultipleJumps {

    public static void main(String[] args) {
        int[][] maze = {{2,1,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};
        int n = 4;

        int[][] out = solve(n, maze);
        for(int i=0;i < n;i++){
            for(int j=0;j <n ;j++){
                System.out.print(out[i][j] +" ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int n, int[][] maze) {
        // code here
        int[][] vis = new int[n][n];
        int[] x ={0,1};
        int[] y={1,0};
        if(maze[0][0] == 0){
            return vis;
        }
        char[] c = {'D', 'R'};
        vis[0][0]=1;
        dfs(maze, vis, x, y, c, n, 0, 0);

        return vis;
    }

    public static void dfs(int[][] maze, int[][] vis, int[] x ,int[] y , char[] c, int n, int i, int j){
        if(i == n-1 && j ==n-1){
            return;
        }

        int jump = maze[i][j];
        for(int ii=1;ii<=jump;ii++){
            if(isSafe(maze,vis,n, i+ii,j)){
                vis[i+ii][j] = 1;
                dfs(maze, vis, x, y, c, n, i, j);
                vis[i+ii][j] = 0;
            }else if(isSafe(maze,vis,n, i,j+ii)){
                vis[i][j+ii] = 1;
                dfs(maze, vis, x, y, c, n, i, j);
                vis[i][j+ii] = 0;
            }
        }
    }

   static boolean isSafe(int[][] maze, int[][] vis,int n, int i, int j){
        if(i>= 0 && j >= 0 && i<n && j < n && vis[i][j] != 1){
            return true;
        }
        return false;
    }
}
