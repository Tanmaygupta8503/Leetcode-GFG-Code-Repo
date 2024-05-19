class Solution1 {
    Long dp [][];
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        dp = new Long[nums.length + 1][2];
        return maxSumOfNodes(0 , 1 , nums , k);
    }
    private long maxSumOfNodes(int index, int isEven, int[] nums, int k) {
        if (index == nums.length)
            return isEven == 1 ? 0 : Integer.MIN_VALUE;
        if(dp[index][isEven] != null) return dp[index][isEven];
        long noXorDone = nums[index] + maxSumOfNodes(index + 1, isEven, nums, k);
        long xorDone = (nums[index] ^ k) + maxSumOfNodes(index + 1, isEven ^ 1, nums, k);
        return dp[index][isEven] = Math.max(xorDone, noXorDone);
    }
}

class Solution2{
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int count = 0 , minLoss = Integer.MAX_VALUE;
        for(int i : nums) {
            if((i ^ k) > i) {
                count ++;
                sum += (i ^ k);
            } else {
                sum += i;
            }
            minLoss = Math.min(minLoss , Math.abs(i - (i ^ k)));
        }
        return count % 2 == 0 ? sum : sum - minLoss;
    }
}


class Solution{
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            sum += nums[i];
            nums[i] = (nums[i] ^ k) - nums[i];
        }
        Arrays.sort(nums);
        for(int i = nums.length - 1 ; i > 0  ; i -= 2) {
            sum += nums[i] + nums[i-1] > 0 ? nums[i] + nums[i-1] : 0;
        }
        return sum;
    }
}