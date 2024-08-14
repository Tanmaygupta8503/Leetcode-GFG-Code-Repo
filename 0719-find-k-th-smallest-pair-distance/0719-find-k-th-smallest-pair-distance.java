class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int maxDistance = 1000000;
        int[] count = new int[maxDistance + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                count[Math.abs(nums[j] - nums[i])]++;
            }
        }
        int cumulativeCount = 0;
        for (int i = 0; i <= maxDistance; i++) {
            cumulativeCount += count[i];
            if (cumulativeCount >= k) {
                return i;
            }
        }
        return 0; 
    }
}
