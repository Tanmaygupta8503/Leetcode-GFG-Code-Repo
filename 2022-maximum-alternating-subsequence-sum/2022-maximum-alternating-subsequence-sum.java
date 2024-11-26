class Solution1 {
    Long dp[][];
    public long maxAlternatingSum(int[] nums) {
        dp = new Long [nums.length][2];
        return solve(nums , 0 , true);
    }
    // true = +1;
    // false = -1;
    long solve(int nums[] , int i , boolean sign){
        if(i == nums.length) return 0;
        if(dp[i][sign ? 1 : 0] != null) {
            return dp[i][sign ? 1 : 0];
        }
        long op1 , op2;
        op1 = op2 = Long.MIN_VALUE;
        if(sign){ // sign == +ve
            op1 = nums[i] + solve(nums , i + 1 , !sign);
            op2 = solve(nums , i + 1 , sign);
        }
        else { // sign == -ve
            op1 = -nums[i] + solve(nums , i + 1 , !sign);
            op2 = solve(nums , i + 1 , sign);
        }
        return dp[i][sign ? 1 : 0] = Math.max(op1 , op2);
    }
}

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        dp[n - 1][0] = 0;
        dp[n - 1][1] = nums[n - 1]; 
        for (int i = n - 2; i >= 0; i--) {
            dp[i][1] = Math.max(nums[i] + dp[i + 1][0], dp[i + 1][1]);
            dp[i][0] = Math.max(-nums[i] + dp[i + 1][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }
}
