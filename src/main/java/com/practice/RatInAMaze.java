package com.practice;

public class RatInAMaze {

    public static void main(String[] args) {

        int n = 4;
        int[][] maze = {
                {2, 1, 0, 0},
                {3, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 0, 1}
        };

        RatInAMaze obj = new RatInAMaze();
        int[][] res = obj.solve(n, maze);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[][] solve(int n, int[][] maze) {
        // code here
        int[][] res = new int[n][n];

        if(find(n, maze,res, 0, 0)){
            return res;
        }else{
            //= {{-1}}
            return res ;
        }
    }

    boolean find(int n, int[][] maze, int[][] res, int r, int c){

        if(r >= n || c >=n){
            return false;
        }

        if(r == n-1 && c == n-1){
            res[r][c] = 1;
            return true;
        }

        if(maze[r][c] == 0){
            return false;
        }

        int[] dr = {0,1};
        int[] dc = {1,0};

        int val = maze[r][c];

        if(maze[r][c] != 0) {
            res[r][c] = 1;
            for (int i = 1; i <= val; i++) {

                for (int j = 0; j <= 1; j++) {

                    int row = r + (dr[j] * i);
                    int col = c + (dc[j] * i);
                    if (row < n && col < n && res[row][col] != 1) {
                       // res[row][col] = 1;
                        if (find(n, maze, res, row, col)) {
                            return true;
                        }
                       // res[row][col] = 0;
                    }
                }

            }
            res[r][c] = 0;
        }
        return false;

    }
}
