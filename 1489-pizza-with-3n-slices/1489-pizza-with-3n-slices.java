class Solution {
    public int maxSizeSlices(int[] slices) {
        int n = slices.length , k = n / 3;
        return Math.max(solve(slices, 1, n - 1, k, new Integer[n + 1][k + 1]),
                    solve(slices , 0 , n - 2 , k , new Integer[n + 1][k + 1]));
    }
    private int solve(int arr[] , int start , int end , int k , Integer[][] dp) {
        if (k == 0 || start > end) {
            return 0;
        }
        if (dp[start][k] != null) {
            return dp[start][k];
        }
        int op1 = arr[start] + solve(arr , start + 2 , end , k - 1 , dp);
        int op2 = solve(arr , start + 1 , end , k , dp);
        return dp[start][k] = Math.max(op1 , op2);
    }
}
