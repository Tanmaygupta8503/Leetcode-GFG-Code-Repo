class Solution {
    public boolean judgeSquareSum(int n) {
        long l = 0;
        long r = (int) Math.sqrt(n);
        while(l <= r) {
            if((l * l + r * r) == n) return true;
            if((l * l + r * r) < n) l++;
            else r--;
        }
        return false;
    }
}