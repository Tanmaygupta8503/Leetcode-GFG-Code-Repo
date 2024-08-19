class Solution {
    public int minSteps(int n) {
        int dp [][] = new int [n][n];
        for(int i[] : dp) {
            Arrays.fill(i , -1);
        }
        return solve(n , 1 , /*{copy = '' = }*/ 0 , dp);
    }
    private int solve(int n , int curr ,  int copy , int dp[][]){ 
        if(n == curr) return 0;
        if(curr > n) return Integer.MAX_VALUE / 2;
        int min = Integer.MAX_VALUE / 2;
        int paste = 0;
        if(dp[curr][copy] != -1) return dp[curr][copy];
        if(copy > 0){
            paste = 1 + solve(n , curr + copy , copy , dp);
            min = Math.min(paste , min);
        }
        int copy_text = 0;
        copy_text = 2 + solve(n , curr + curr , curr , dp);
        min = Math.min(copy_text , min);
        return dp[curr][copy] = min; 
    }
}