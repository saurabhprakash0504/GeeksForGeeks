package com.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static void main(String[] args) {
        RottenOranges rottenOranges = new RottenOranges();
        int[][] mat = {
                {2,1,0,2,1},
                {1,0,1,2,1},
                {1,0,0,2,1}
        };

        int ans = rottenOranges.orangesRotting(mat);
        System.out.println(ans);
    }

    public int orangesRotting(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        boolean[][] vis = new boolean[r][c];
        Queue<Pair> queue = new LinkedList<>();

        int count = 0;
        int time = 0;
        for(int i=0;i< r;i++){
            for(int j=0;j< c; j++){
                if(mat[i][j] == 2){
                    queue.add(new Pair(i, j, 0));
                }else if (mat[i][j] ==1){
                    count++;
                }
            }
        }

        int[] rr = {-1,0, 1, 0};
        int[] cc = {0, 1, 0, -1};

        while(!queue.isEmpty()){

            Pair poll = queue.poll();

            if(poll.time > time){
                time = poll.time;
            }


            for(int i=0;i<rr.length;i++){
                int nr = poll.r + rr[i];
                int nc = poll.c + cc[i];
                if(nr >=0 && nc >=0 && nr < r && nc < c){

                    if(vis[nr][nc] == false){
                        if(mat[nr][nc] == 1){
                            vis[nr][nc] = true;
                            count--;
                            queue.add(new Pair(nr, nc, poll.time+1));
                        }
                    }

                }
            }
        }
        return count == 0 ? time : -1;
    }
}


class Pair {

    int r ;
    int c;
    int time;

    Pair(int r, int c, int t){
        this.r = r;
        this.c = c;
        this.time = t;
    }
}