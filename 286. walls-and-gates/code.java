import java.util.* ;
import java.io.*; 
public class Solution {
    public static int[][] wallsAndGates(int[][] a, int n, int m) {
        Queue<int[]> queue_of_walls = new LinkedList<>();
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                if(a[i][j] == 0) queue_of_walls.add(new int [] {i , j , 0});
            }
        }
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        while(!queue_of_walls.isEmpty()){
            int node [] = queue_of_walls.poll();
            int i = node[0];
            int j = node[1];
            int step = node[2];
            for(int k = 0 ; k < 4 ; k ++) {
                int X = i + dx[k];
                int Y = j + dy[k];
                if(X >= 0 && Y >= 0 && X < n && Y < m && a[X][Y] != -1) {
                    if(a[X][Y] > step + 1){
                        a[X][Y] = Math.min(a[X][Y] , step + 1);
                        queue_of_walls.add(new int[]{X , Y , step + 1});
                    }
                }
            }
        }
        return a;
    }
}

