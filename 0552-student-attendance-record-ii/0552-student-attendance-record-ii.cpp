class SolutionRec {
public:
int dp[100001][2][3];
    int checkRecord(int n) {
        memset(dp , -1 , sizeof(dp));
        return solve(n , 0 , 0);
    }
    int solve(int n , int a , int l) {
        if(n == 0 && a < 2 && l < 3) return dp[n][a][l] = 1;
        if(l >= 3) return 0;
        if(a >= 2) return 0;
        if(dp[n][a][l] != -1) return dp[n][a][l];
        int op1 = solve(n - 1 , a + 1 , 0);
        int op2 = solve(n - 1 , a , 0);
        int op3 = solve(n - 1 , a , l + 1);
        return dp[n][a][l] = op1 + op2 + op3;
    }
};


class Solution {
public:
    int mod = 1000000007;
    int checkRecord(int n) {
        vector<vector<vector<int>>> dp(n + 1, vector<vector<int>>(4, vector<int>(3, -1)));
        return solve(n, 0, 0, dp);
    }

    int solve(int n, int a, int l, vector<vector<vector<int>>> &dp) {
        if (n == 0 && a < 2 && l < 3)
            return 1;
        if (l >= 3 || a >= 2)
            return 0;
        if (dp[n][l][a] != -1)
            return dp[n][l][a];
        long op1 = solve(n - 1, a + 1, 0, dp);
        long op2 = solve(n - 1, a, 0, dp);
        long op3 = solve(n - 1, a, l + 1, dp);
        return dp[n][l][a] = (op1 + op2 + op3) % mod;
    }
};
