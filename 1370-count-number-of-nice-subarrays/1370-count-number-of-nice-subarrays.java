class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }
    private int atMostK(int[] nums, int k) {
        int ws = 0, we;
        int subarrayCount = 0;
        int oddCount = 0;
        for (we = 0; we < nums.length; we++) {
            if (nums[we] % 2 == 1) {
                oddCount++;
            }
            while (oddCount > k) {
                if (nums[ws] % 2 == 1) {
                    oddCount--;
                }
                ws++;
            }
            subarrayCount += we - ws + 1;
        }
        return subarrayCount;
    }
}
