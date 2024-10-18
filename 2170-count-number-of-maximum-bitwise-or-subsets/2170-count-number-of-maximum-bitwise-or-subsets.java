class Solution {
    public int countMaxOrSubsets(int[] nums) {
        List<List<Integer>> list = subsets(nums);
        int or = 0;
        for(int i : nums) {
            or |= i;
        }
        int cnt = 0;
        for(var l : list) {
            if(orSum(l) == or) {
                cnt ++;
            }
        }
        return cnt;
    }
    public int orSum(List<Integer> list) {
        int or = 0;
        for(int i : list) {
            or |= i;
        }
        return or;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        int totalSubsets = 1 << n;        
        for (int i = 0; i < totalSubsets; i++) {
            List<Integer> subset = new ArrayList<>();    
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        }        
        return result;
    }
}