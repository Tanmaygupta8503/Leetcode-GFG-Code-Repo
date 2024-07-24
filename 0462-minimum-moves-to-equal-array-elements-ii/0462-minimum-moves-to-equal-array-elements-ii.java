class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median = 0;
        if(nums.length == 1) return 0;
        if(nums.length % 2 == 0) {
            median = (int)Math.floor((nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0);
        }else{
            median = nums[nums.length / 2];
        }
        int cost = 0;
        for(int i : nums) {
            cost += Math.abs(i - median);
        }
        return cost;
    }
}