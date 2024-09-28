class Solution {
    Boolean dp[][];
    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length()][p.length()];
        return solve(0, 0, s, p);
    }
    boolean solve(int i, int j, String s, String p) {
        if (i == s.length()) {
            while (j < p.length() && p.charAt(j) == '*') {
                j++;
            }
            return j == p.length();
        }
        if (j == p.length()) {
            return false; 
        }
        if(dp[i][j] != null) return dp[i][j];
        if (p.charAt(j) == '*') {
            return dp[i][j] = 
                               solve(i + 1, j, s, p) 
                            || solve(i, j + 1, s, p);
        }
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            return dp[i][j] = solve(i + 1, j + 1, s, p); 
        }
        return dp[i][j] = false;
    }
}
