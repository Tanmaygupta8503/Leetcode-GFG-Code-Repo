class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        // Step 1: Find the break point (ind):
        int ind = -1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                ind = i;
                break;
            }
        }
        // Step 2: If no break point exists, reverse the entire array:
        if (ind == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // Step 3: Find the next greater element than nums[ind] to swap:
        for (int i = n - 1; i > ind; i--) {
            if (nums[i] > nums[ind]) {
                swap(nums, i, ind);
                break;
            }
        }   
        // Step 4: Reverse the right half after the break point:
        reverse(nums, ind + 1, n - 1);
    }    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}