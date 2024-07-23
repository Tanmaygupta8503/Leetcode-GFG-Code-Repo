class Solution {
    List<String> str;
    public List<String> generateParenthesis(int n) {
        str = new ArrayList<>();
        solve(n, n, "");
        return str;
    }
    void solve(int open, int close, String s) {
        if (open == 0 && close == 0) {
            str.add(s);
            return;
        }
        if (open > 0) {
            solve(open - 1, close, s + "(");
        }
        if (close > open) {
            solve(open, close - 1, s + ")");
        }
    }
}
