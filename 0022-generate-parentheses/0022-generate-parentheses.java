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
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '(') {
                stack.push(i);
            } else if (i == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
