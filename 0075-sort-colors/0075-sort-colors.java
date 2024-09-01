class Solution {
    public void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        while(mid <= high) {
            switch(nums[mid]) {
                case 0 -> {
                    // if mid has 0
                    int low_val = nums[low]; // save low value
                    nums[low ++] = nums[mid]; // copy midvalue in
                    nums[mid ++] = low_val; // put low's val in mids place
                }
                case 1 -> {
                    mid ++; // mid has 1 them forward the pointer
                }
                case 2 -> {
                    // mid has 2
                    int high_val = nums[high];
                    nums[high --] = nums[mid];
                    nums[mid] = high_val;
                }
                default -> {
                    throw new IllegalArgumentException("number has value other than 0 , 1 or 2");
                }
            }
        }
        return;
    }
}