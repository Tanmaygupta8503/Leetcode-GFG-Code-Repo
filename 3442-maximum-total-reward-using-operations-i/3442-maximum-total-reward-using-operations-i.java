class Solution {
    public int maxTotalReward(int[] rewardValues) {
        // Sort the array in ascending order
        Arrays.sort(rewardValues);
        int n = rewardValues.length;
        Integer[][] dp = new Integer[n][4005];
        return solve(rewardValues, 0, 0, dp);
    }

    int solve(int[] arr, int idx, int currentReward, Integer[][] dp) {
        if (idx >= arr.length) return currentReward;
        if (dp[idx][currentReward] != null) {
            return dp[idx][currentReward];
        }
        int op1 = currentReward;
        if (arr[idx] > currentReward) {
            op1 = solve(arr, idx + 1, currentReward + arr[idx], dp);
        }
        int op2 = solve(arr, idx + 1, currentReward, dp);
        dp[idx][currentReward] = Math.max(op1, op2);
        return dp[idx][currentReward];
    }
}