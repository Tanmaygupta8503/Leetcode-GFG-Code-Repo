class Solution {
    public void moveZeroes(int[] nums) {
        int zero = findFirstZero(nums);
        if(zero == -1) return ;
        int nonZero = findNonNegativeAfterIdx(nums , zero);
        if(nonZero == -1 || zero == -1) return;
        int t = nums[zero];
        nums[zero] = nums[nonZero];
        nums[nonZero] = t;
        moveZeroes(nums);
    }
    int findFirstZero(int nums[]){
        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == 0) return i; 
        }
        return -1;
    }
    int findNonNegativeAfterIdx(int nums[] , int idx) {
        for(int i = idx ; i < nums.length ; i ++) {
            if(nums[i] != 0) return i;
        }
        return -1;
    }
}