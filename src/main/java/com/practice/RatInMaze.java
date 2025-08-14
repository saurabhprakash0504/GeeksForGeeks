package com.practice;

public class RatInMaze {

    public static void main(String[] args) {

        int n = 4, maze[][] = {{2,1,0,0},{3,0,0,1},{0,1,0,1},{0,0,0,1}};

        RatInMaze r = new RatInMaze();
        int[][] res = r.solve(n, maze);
        for(int i=0;i<res.length;i++){
            for(int j=0;j< res[0].length;j++){
                System.out.print(res[i][j] +" ");
            }
            System.out.println();
        }

    }

    public int[][] solve(int n, int[][] maze) {
        int r = maze.length;
        int c = maze[0].length;

        if(maze[0][0] == 0){
            int[][] res = {{-1}};
            return res;
        }

        int[][] res = new int[r][c];

        //   int[] dir = {1,0};
        //  int[] dic = {0,1};

        dfs(maze, 0, 0, r, c, res);

     /*   for(int i=0;i< r;i++){
            for(int j=0;j < c;j++){
                if(maze[i][j] !=0){
                    dfs(maze, i, j, r, c, res);
                }
            }
        }*/
        if(flag){
            return res;
        }else{
            int[][] res1 = {{-1}};
            return res1;
        }



    }

    boolean flag = false;

    void dfs(int[][] maze, int i, int j, int r, int c, int[][] res){

        if(i== r-1 && j == c-1){
            flag = true;
            return;
        }
        int size = maze[i][j];
        for(int ind=1;ind<=size;ind++){
            if(isSafe(ind+i, j, r, c, maze)){
                res[ind+i][j]= 1;
                dfs(maze, ind+i, j, r,c,res);
                res[ind+i][j]=0;
            }
            if(isSafe(i, ind+j, r, c, maze)){
                res[i][ind+j]= 1;
                dfs(maze, i, ind+j, r,c,res);
                res[i][ind+j]= 0;
            }
        }
    }

    boolean isSafe(int i, int j, int r, int c,int[][] maze){
        if(i<r && i>=0 && j<c && j >=0 && maze[i][j]!= 0){
            return true;
        }
        else{
            return false;
        }
    }

}
