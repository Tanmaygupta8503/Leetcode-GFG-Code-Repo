class Solution {
    Integer dp[][];
    public int maxProfit(int[] prices) {
        dp = new Integer [prices.length][2];
        return solve(prices , 0 , true);
    }
    public int solve(int prices[] , int idx , boolean buy) {
        if(idx >= prices.length) {
            return 0;
        }
        if(dp[idx][buy ? 1 : 0] != null) return dp[idx][buy ? 1 : 0];
        if(buy) {
            int op1 = -prices[idx] + solve(prices , idx + 1 , !buy);
            int op2 = solve(prices , idx + 1 , buy);
            return dp[idx][buy ? 1 : 0] = Math.max(op1 , op2);
        } else {
            int op1 = solve(prices , idx + 1 , buy);
            int op2 = +prices[idx] + solve(prices , idx + 1 , !buy);
            return dp[idx][buy ? 1 : 0] = Math.max(op1 , op2);
        }
    }
}