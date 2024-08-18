class Solution1 {
    Integer[][] dp = new Integer[101][10001];
    public int superEggDrop(int egg, int floor) {
        if (floor == 0 || floor == 1) return floor;
        if (egg == 1) return floor;
        if (dp[egg][floor] != null) return dp[egg][floor];
        int min = Integer.MAX_VALUE;
        for (int f = 1; f <= floor; f++) {
            int a = (dp[egg - 1][f - 1] != null) ? dp[egg - 1][f - 1] : superEggDrop(egg - 1, f - 1);
            int b = (dp[egg][floor - f] != null) ? dp[egg][floor - f] : superEggDrop(egg, floor - f);
            min = Math.min(min, 1 + Math.max(a, b));
        }
        dp[egg][floor] = min;
        return min;
    }
}
class Solution3{
    public int superEggDrop(int egg, int floor) {
        int[][] dp = new int[egg + 1][floor + 1];
        for (int i = 1; i <= egg; i++) {
            dp[i][0] = 0; 
            dp[i][1] = 1; 
        }
        for (int j = 1; j <= floor; j++) {
            dp[1][j] = j;
        }
        for (int i = 2; i <= egg; i++) {
            for (int j = 2; j <= floor; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int f = 1; f <= j; f++) {
                    int broken = dp[i - 1][f - 1];
                    int notbroken = dp[i][j - f];
                    int worstCase = 1 + Math.max(broken, notbroken);
                    dp[i][j] = Math.min(dp[i][j], worstCase);
                }
            }
        }
        return dp[egg][floor];
    }
}

class Solution{
    public int superEggDrop(int egg, int floor) {
        int[][] dp = new int[floor + 1][egg + 1];
        int move = 0;
        while (dp[move][egg] < floor) {
            move ++;
            for(int eg = 1 ; eg <= egg ; eg ++) {
                dp[move][eg] = dp[move - 1][eg - 1] + dp[move - 1][eg] + 1;
            }
        }
        return move;
    }
}