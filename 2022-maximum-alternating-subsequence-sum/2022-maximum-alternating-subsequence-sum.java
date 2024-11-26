class Solution {
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