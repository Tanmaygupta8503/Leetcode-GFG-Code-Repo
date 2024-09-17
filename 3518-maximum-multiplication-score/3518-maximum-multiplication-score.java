class Solution {
    Long dp[][];
    public long maxScore(int[] a, int[] b) {
        dp = new Long[b.length][4];
        return solve(a , b , 0 , 0);
    }
    long solve(int a[] , int b[] , int i , int j) {
        if(i >= b.length) {
            if(j == 4) return 0;
            else {
                return Long.MIN_VALUE;
            }
        }
        if(j == 4) {
            return 0;
        }
        if(dp[i][j] != null)return dp[i][j];
        long op1 = solve(a , b , i + 1 , j + 1);
        if(op1 == Long.MIN_VALUE){
            op1 = Long.MIN_VALUE;
        }else{
            op1 += a[j] * 1L * b[i];
        }
        long op2 = solve(a , b , i + 1 , j); 
        return dp[i][j] = Math.max(op1 , op2);
    }
}