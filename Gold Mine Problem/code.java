class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        // code here
        int max = 0;
        Integer dp [][] = new Integer[n + 1][m + 1];
        for(int i = 0 ; i < n ; i ++){
            int ans = solve(n , m , M , i , 0 , dp);
            max = Math.max(max , ans);
        }
        return max;
    }
    static int solve(int n , int m , int arr[][] , int i , int j , Integer dp[][]) {
        if(i >= n || j >= m || j < 0 || i < 0) return 0;
        if(dp[i][j] != null) return dp[i][j];
        int op1 = arr[i][j] + solve(n , m , arr , i , j + 1 , dp);
        int op2 = arr[i][j] + solve(n , m , arr , i + 1 , j + 1 , dp);
        int op3 = arr[i][j] + solve(n , m , arr , i - 1 , j + 1 , dp);
        return dp[i][j] = Math.max(op1 , Math.max(op2 , op3));
    }
}
