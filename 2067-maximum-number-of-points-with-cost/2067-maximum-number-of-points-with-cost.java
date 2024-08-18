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



class Solution2 {
    public long maxPoints(int[][] point) {
        int n = point.length;
        int m = point[0].length;
        long points[][] = new long[n][m];
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                points[i][j] = point[i][j];
            }
        }
        for (int row = 1; row < n; row++) {
            for (int col = 0; col < m; col++) {
                long maxVal = Long.MIN_VALUE;
                for (int k = 0; k < m; k++) {
                    maxVal = Math.max(maxVal, points[row - 1][k] - Math.abs(col - k));
                }
                points[row][col] += maxVal;
            }
        }
        long max = 0;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, points[n - 1][i]);
        }
        return max;
    }
}


class Solution {
    public long maxPoints(int[][] point) {
        int m = point.length;
        int n = point[0].length;
        long prev [] = new long[n];
        for(int i = 0 ; i < n ; i ++) {
            prev[i] = point[0][i];
        }
        for(int i = 1 ; i < m ; i ++) {
            long left[] = new long[n];
            long right[] = new long[n];
            left[0] = prev[0];
            for(int j = 1 ; j < n ; j ++) {
                left[j] = Math.max(prev[j] , left[j - 1] - 1);
            }
            right[n - 1] = prev[n - 1];
            for(int j = n - 2 ; j >= 0 ; j --) {
                right[j] = Math.max(prev[j] , right[j + 1] - 1);
            }
            long curr[] = new long[n];
            for(int j = 0 ; j < n ; j ++) {
                curr[j] = point[i][j] + Math.max(left[j] , right[j]);
            }
            prev = curr;
        }
        long max = 0;
        for(long i : prev) max = Math.max(i , max);
        return max;
    }
}