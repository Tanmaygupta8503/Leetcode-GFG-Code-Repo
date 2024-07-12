class Solution {
    Integer dp[];
    public int maxSumAfterPartitioning(int[] arr, int k) {
        dp = new Integer[arr.length + 1];
        return solve(arr , k , 0);
    }
    public int solve(int arr[] , int k , int idx) {
        if(idx >= arr.length) {
            return 0;
        }
        if(dp[idx] != null) return dp[idx];
        int currmax = 0 , sum = 0, max = 0;
        for(int i = idx ; i < idx + k && i < arr.length ; i ++) {
            currmax = Math.max(arr[i] , currmax);
            sum = currmax * (i - idx + 1) + solve(arr , k , i + 1);
            max = Math.max(sum , max);
        }
        return dp[idx] = max;
    }
}