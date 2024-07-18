class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i =  0 ; i < n ; i ++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1 ; j < n ; j ++) {
                // if (j > 0 && nums[j] == nums[j - 1]) continue;
                int low = j + 1;
                int high = n - 1;
                long sum = nums[i] + nums[j];
                while(low < high) {
                    if((sum + (nums[low] + nums[high])) == target) {
                        ans.add(Arrays.asList(nums[i] , nums[j] , nums[low] , nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) low ++;
                        while (low < high && nums[high] == nums[high - 1]) high --;
                        low ++;
                        high --;
                    }
                    else if((sum + nums[low] + nums[high]) < target){
                        low ++;
                    }
                    else{
                        high --;
                    }
                }
            }
        }
        return new ArrayList<>(ans);
    }
}