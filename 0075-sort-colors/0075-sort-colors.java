class Solution {
    public void sortColors(int[] nums) {
        int one = 0 , zero = 0 , two = 0;
        for(int i : nums) {
            zero += i == 0 ? 1 : 0;
            one += i == 1 ? 1 : 0;
            two += i == 2 ? 1 : 0;
        }
        int ptr = 0;
        while(ptr < nums.length) {
            while(zero -- > 0) 
                nums[ptr ++] = 0;
            while(one -- > 0) 
                nums[ptr ++] = 1;
            
            while(two -- > 0)
                nums[ptr ++] = 2;
        }
    }
}