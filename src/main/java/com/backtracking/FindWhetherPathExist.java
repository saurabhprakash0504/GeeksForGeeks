package com.backtracking;

public class FindWhetherPathExist {

    public static void main(String[] args) {
        int[][] grid = {
                {0, 3, 2, 0},
                {3, 0, 0, 0},
                {1, 0, 3, 3},
                {0, 0, 0, 2}
        };

        FindWhetherPathExist obj = new FindWhetherPathExist();

        System.out.println(obj.is_Possible(grid));
    }

    public boolean is_Possible(int[][] grid) {
        // Code here
        int startRow = 0;
        int startCol = 0;

        int destRow = 0;
        int destCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }

                if (grid[i][j] == 2) {
                    destRow = i;
                    destCol = j;
                }
            }
        }

        int r = grid.length;
        int c = grid[0].length;

        boolean[][] vis = new boolean[r][c];
      //  return find(grid, vis, r, c, startRow, startCol, destRow, destCol);
        return find2(grid, vis, r, c, startRow, startCol, destRow, destCol);
    }


    boolean find(int[][] grid, boolean[][] vis, int r, int c, int startRow, int startCol, int destRow, int destCol) {


        if (startRow == destRow && startCol == destCol) {

            return true;
        }

        int nr = startRow - 1;
        int nc = startCol;
        if (nr >= 0 && nc >= 0 && nr < r && nc < c && vis[nr][nc] == false && grid[nr][nc] != 0) {
            vis[nr][nc] = true;
            if (find(grid, vis, r, c, nr, nc, destRow, destCol)) {
                return true;
            }
            vis[nr][nc] = false;
        }


        int nr1 = startRow + 1;
        int nc1 = startCol;
        if (nr1 >= 0 && nc1 >= 0 && nr1 < r && nc1 < c && vis[nr1][nc1] == false && grid[nr1][nc1] != 0) {
            vis[nr1][nc1] = true;
            if (find(grid, vis, r, c, nr1, nc1, destRow, destCol)) {
                return true;
            }

            vis[nr1][nc1] = false;
        }


        int nr2 = startRow;
        int nc2 = startCol + 1;
        if (nr2 >= 0 && nc2 >= 0 && nr2 < r && nc2 < c && vis[nr2][nc2] == false && grid[nr2][nc2] != 0) {
            vis[nr2][nc2] = true;
            if (find(grid, vis, r, c, nr2, nc2, destRow, destCol)) {
                return true;
            }
            vis[nr2][nc2] = false;
        }


        int nr3 = startRow;
        int nc3 = startCol - 1;
        if (nr3 >= 0 && nc3 >= 0 && nr3 < r && nc3 < c && vis[nr3][nc3] == false && grid[nr3][nc3] != 0) {
            vis[nr3][nc3] = true;
            if (find(grid, vis, r, c, nr3, nc3, destRow, destCol)) {
                return true;
            }

            vis[nr3][nc3] = false;
        }


        return false;


    }

    boolean find2(int[][] grid, boolean[][] vis, int r, int c, int startRow, int startCol, int destRow, int destCol) {

        if (startRow == destRow && startCol == destCol) {

            return true;
        }

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nr = startRow + dr[i];
            int nc = startCol + dc[i];
            if (nr >= 0 && nc >= 0 && nr < r && nc < c && vis[nr][nc] == false && grid[nr][nc] != 0) {
                vis[nr][nc] = true;
                if (find(grid, vis, r, c, nr, nc, destRow, destCol)) {
                    return true;
                }
                vis[nr][nc] = false;
            }

        }

        return false;

    }
}


