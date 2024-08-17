class Solution1 {
    Long[][]dp;
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        dp = new Long[n][m + 1];
        return solve(/*{row = 0}*/ 0 , /*points array*/ points , /*{prevCol = -1 }*/  -1);
    }
    long solve(int row , int points[][] , int prevCol) {
        int n = points.length;
        int m = points[0].length;
        if(row >= n) return 0;
        if(dp[row][prevCol + 1] != null) 
            return dp[row][prevCol + 1];
        long max = 0;
        for(int col = 0 ; col < m ; col ++) {
            long sum = points[row][col] - (prevCol == -1 ? 0 : Math.abs(prevCol - col))
                    + solve(row + 1, points, col);
            max = Math.max(sum, max);
        }
        return dp[row][prevCol + 1] = max;
    }
}



class Solution {
    public long maxPoints(int[][] points) {
        int cols = points[0].length;
        long[] currentRow = new long[cols], previousRow = new long[cols];
        for (int[] row : points) {
            long runningMax = 0;
            for (int col = 0; col < cols; ++col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = runningMax;
            }
            for (int col = cols - 1; col >= 0; --col) {
                runningMax = Math.max(runningMax - 1, previousRow[col]);
                currentRow[col] = Math.max(currentRow[col], runningMax) + row[col];
            }
            previousRow = currentRow;
        }
        long maxPoints = 0;
        for (int col = 0; col < cols; ++col) {
            maxPoints = Math.max(maxPoints, previousRow[col]);
        }
        return maxPoints;
    }
}