class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0, mini = Long.MAX_VALUE;
        int n = matrix.length, cnt = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] < 0) {
                    cnt++;
                }
                mini = Math.min(Math.abs(matrix[row][col]), mini);
                sum += Math.abs(matrix[row][col]);
            }
        }
        
        if (cnt % 2 == 1) { // count is odd
            sum -= (2 * mini);
        }
        return sum;
    }
}