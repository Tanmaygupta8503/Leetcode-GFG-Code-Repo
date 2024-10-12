class Solution {
    int total;
    Boolean dp[][];
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        this.total = sum;
        if(sum % 2 == 1) return false;
        dp = new Boolean [nums.length][sum + 1];
        return solve(nums , 0 , 0);
    }
    boolean solve(int nums[] , int i , int sum) {
        if(sum + sum == total) return true;
        if(i == nums.length) return false;
        if(dp[i][sum] != null) return dp[i][sum];
        boolean op1 = solve(nums , i + 1 , sum);
        boolean op2 = solve(nums , i + 1 , sum + nums[i]);
        return dp[i][sum] = op1 | op2;
    }
}