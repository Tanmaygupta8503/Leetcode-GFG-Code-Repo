class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        return beautifulSubsets(nums , k , new ArrayList<Integer>() , 0) - 1;
    }
    private boolean isBeautiful(List<Integer>list , int num , int k) {
        for(int i : list) {
            if(num > i && num - i == k) return false;
            if(i > num && i - num == k) return false;
        }
        return true;
    }
    public int beautifulSubsets(int []nums , int k , List<Integer> list , int i) {
        if(i == nums.length) {
            return 1;
        }
        int op1 = 0, op2 = 0;
        if(isBeautiful(list , nums[i] , k)){
            list.add(nums[i]);
            op1 = beautifulSubsets(nums , k , list , i + 1);
            list.remove(list.size() - 1);
        }
        op2 = beautifulSubsets(nums , k , list , i + 1);
        return op1 + op2;
    }
}

class Solution1 {
    public int beautifulSubsets(int[] nums, int k) {
        return subsets(nums , k) - 1;
    }
    public boolean isBeautiful(List<Integer> nums , int k) {
        // for(int i = 0 ; i < nums.size() ; i ++) {
        //     for(int j = i + 1 ; j < nums.size() ; j ++) {
        //         if(Math.abs(nums.get(i) - nums.get(j)) == k) {
        //             return false;
        //         }
        //     }
        // }
        // return true;
        Set<Integer> set = new HashSet<>();
        for(int i : nums) {
            if(set.contains(i + k)) return false;
            if(i > k && set.contains(Math.abs(i - k))) return false;
            set.add(i);
        }
        return true;
    }
    public int subsets(int[] nums, int k) {
        int size = nums.length;
        int cnt = 0;
        for(int i = 0 ; i < Math.pow(2,size) ; i ++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < size ; j ++) {
                if((i & (1 << j)) != 0)
                    temp.add(nums[j]);
            }
            if(isBeautiful(temp , k)) cnt ++;
        }
        return cnt;
    }
}

class Solution2 {
    public int beautifulSubsets(int[] nums, int k) {
        return subsets(nums , k) - 1;
    }
    public boolean isBeautiful(List<Integer> nums , int k) {
        for(int i = 0 ; i < nums.size() ; i ++) {
            for(int j = i + 1 ; j < nums.size() ; j ++) {
                if(Math.abs(nums.get(i) - nums.get(j)) == k) {
                    return false;
                }
            }
        }
        return true;
    }
    public int subsets(int[] nums, int k) {
        int size = nums.length;
        int cnt = 0;
        for(int i = 0 ; i < Math.pow(2,size) ; i ++) {
            List<Integer> temp = new ArrayList<>();
            for(int j = 0 ; j < size ; j ++) {
                if((i & (1 << j)) != 0)
                    temp.add(nums[j]);
            }
            if(isBeautiful(temp , k)) cnt ++;
        }
        return cnt;
    }
}