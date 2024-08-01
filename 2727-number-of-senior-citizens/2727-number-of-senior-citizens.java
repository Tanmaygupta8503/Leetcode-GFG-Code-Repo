class Solution {
    public int countSeniors(String[] details) {
        return (int)Arrays.stream(details)
                          .filter(a -> (0 + (a.charAt(11)-'0') * 10 + (a.charAt(12) - '0')) > 60)
                          .count();
    }
}