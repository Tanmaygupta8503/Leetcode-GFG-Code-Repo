class Solution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        for(int i = 0 ; i < n ; i ++) {
            int low = i + 1;
            int high = n - 1;
            int sum = -1*nums[i];
            while(low < high) {
                if(sum - (nums[low] + nums[high]) == 0) {
                    ans.add(Arrays.asList(-sum , nums[low] , nums[high]));
                }
                if(sum > nums[low] + nums[high]){
                    low ++;
                }
                else{
                    high --;
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int low = i + 1;
            int high = n - 1;
            int sum = -1*nums[i];
            while(low < high) {
                if(sum - (nums[low] + nums[high]) == 0) {
                    ans.add(Arrays.asList(-sum , nums[low] , nums[high]));
                    while (low < high && nums[low] == nums[low + 1]) low ++;
                    while (low < high && nums[high] == nums[high - 1]) high --;
                    low ++;
                    high --;
                }
                else if(sum > nums[low] + nums[high]){
                    low ++;
                }
                else{
                    high --;
                }
            }
        }
        return ans;
    }
}