class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int we = 0, ws = 0;
        long sum = 0 , max = 0;
        for(we = 0 ; we < nums.length ; we ++) {
            while(set.contains(nums[we])){
                sum -= nums[ws];
                set.remove(nums[ws]);
                ws ++;
            }
            sum += nums[we];
            set.add(nums[we]);
            if(set.size() == k) {
                max = Math.max(max , sum);
                set.remove(nums[ws]);
                sum -= nums[ws];
                ws ++;
            }
        }
        return max;
    }
}