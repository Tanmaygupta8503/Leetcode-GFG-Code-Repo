class Solution {
    public List<List<String>> solveNQueens(int n) {
        int board[][] = new int [n][n];
        List<List<String>> result = new ArrayList<>();
	    placeQueen(n , 0 , board , result);
        return result;
    }
    
	public void placeQueen(int n , int col ,int [][] board , List<List<String>> result){
        if(col == n){
            List<String> temp = new ArrayList<>();
            for(int i [] : board){
                StringBuilder sb = new StringBuilder();
                for(int j : i){
                    if(j == 1)
                    sb.append("Q");
                    else{
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
            return ;
        }
        for (int r = 0 ; r < n ; r ++) {
            if(isvalid(r , col ,board))
            {
                board[r][col] = 1;
                placeQueen(n , col + 1 , board , result);
                board[r][col] = 0;
            }
        }
    }
    public boolean isvalid(int row , int col , int [][] board){
        int n = board.length;
        for(int i = 0 ; i < n ; i ++){
            if(board[row][i] == 1)
            {
                return false;
            }
        }
        for(int i = 0 ; i < n ; i ++){
            if(board[i][col] == 1){
                return false;
            }
        }
        
        // upper left
        for(int r = row , c = col ; r >= 0 && c >= 0 ; c -- , r --){
            if(board[r][c] == 1){
                return false;
            }
        }
        //upper right
        for(int r = row , c = col ; r >= 0 && c < n ; c ++ , r --){
            if(board[r][c] == 1){
                return false;
            }
        }
        //lower left
        for(int r = row ,  c = col ; r < n && c >=0  ; c -- , r ++){
            if(board[r][c] == 1){
                return false;
            }
        }
        // upper right
        for(int r = row ,  c = col ; r < n && c < n ; c ++ , r ++){
            if(board[r][c] == 1){
                return false;
            }
        }
        return true;
    }
}