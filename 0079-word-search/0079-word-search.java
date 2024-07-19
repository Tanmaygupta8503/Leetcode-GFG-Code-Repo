class Solution {
    int dxdy [][] = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    boolean dfs(char[][] board, String word, int i, int j, int index) {
        if(index == word.length()) {
            return true;
        }
        int n = board.length;
        int m = board[0].length;
        if(i < 0 || j < 0 || i >= n || j >= m || board[i][j] != word.charAt(index)) {
            return false;
        }        
        char temp = board[i][j];
        board[i][j] = '#';
        for(int[] dir : dxdy) {
            int X = i + dir[0];
            int Y = j + dir[1];
            if(dfs(board, word, X, Y, index + 1)) {
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }
}
