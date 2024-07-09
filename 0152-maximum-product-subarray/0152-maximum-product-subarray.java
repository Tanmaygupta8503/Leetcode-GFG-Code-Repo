class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        double p = 1, s = 1;
        double max = Integer.MIN_VALUE; 
        for (int i = 0; i < n; i++) {
            p *= nums[i];
            s *= nums[n - i - 1];
            max = Math.max(max, Math.max(p, s));
            if (p == 0) p = 1; 
            if (s == 0) s = 1; 
        }
        return (int)max;
    }
}
