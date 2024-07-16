class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid = 0;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0 -> {
                    // swap low and mid;
                    int t = nums[low];
                    nums[low ++] = nums[mid];
                    nums[mid ++] = t;
                }
                case 1 -> {
                    mid ++;
                }
                case 2 -> {
                    //swap high and mid
                    int t = nums[mid];
                    nums[mid] = nums[high];
                    nums[high --] = t;
                }
                default -> {
                    throw new IllegalArgumentException("number must be between 0 and 2.");
                } 
            }
        }
    }
}