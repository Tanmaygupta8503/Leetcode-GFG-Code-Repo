class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length , m = board[0].length;
        int ans[][] = new int[board.length][board[0].length];
        // copy array
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                ans[i][j] = board[i][j];
            }
        }
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                int live = 0 , dead = 0;
                for(int k = -1 ; k <= 1 ; k ++) {
                    for(int l = -1 ; l <= 1 ; l ++) {
                        int X = i + k;
                        int Y = j + l;
                        if(X >= 0 && Y >= 0 && X < n && Y < m){
                            if(ans[X][Y] == 0) {
                                dead ++;
                            }
                            else{
                                live ++;
                            }
                        }
                    }
                }
                if(ans[i][j] == 1){
                    live --;
                    // 1.Any live cell with fewer than two live neighbors dies as if caused by under-population.
                    if(live < 2) board[i][j] = 0; 
                    // 2.Any live cell with two or three live neighbors lives on to the next generation.
                    else if(live >= 2 && live <= 3) board[i][j] = 1;
                    // 3.Any live cell with more than three live neighbors dies, as if by over-population.
                    else if(live > 3) board[i][j] = 0;
                }
                else{
                // 4.Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.    
                    if(live == 3) board[i][j] = 1;
                }
            }
        }
    }
}