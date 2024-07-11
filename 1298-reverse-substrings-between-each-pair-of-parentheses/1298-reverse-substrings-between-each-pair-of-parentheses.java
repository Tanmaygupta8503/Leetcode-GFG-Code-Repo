class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (true) {
            int open = sb.lastIndexOf("(");
            if (open == -1) break;
            int close = sb.indexOf(")", open);
            if (close == -1) break;
            String reversedSubstring = new StringBuilder
                                            (sb.substring(open + 1, close))
                                            .reverse().toString();
            sb.replace(open, close + 1, reversedSubstring);
        }
        return sb.toString();
    }
}