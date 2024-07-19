class Solution1 {
    Boolean []dp;
    public boolean canJump(int[] nums) {
        dp = new Boolean[nums.length + 1];
        if(nums.length == 1) return true;
        return solve(nums , 0);
    }
    private boolean solve(int []nums , int idx) {
        if(idx >= nums.length - 1) return true;
        if(dp[idx] != null) return dp[idx];
        boolean ans = false;
        for(int i = 1 ; i <= nums[idx] ; i ++) {
            ans = ans || solve(nums , idx + i);
        }
        return dp[idx] = ans;
    }
}



class Solution {
    public boolean canJump(int[] nums) {
        int move = nums[0];
        for(int i = 1 ; i < nums.length ; i ++) {
            move --;
            if(move < 0) return false;
            move = Math.max(move , nums[i]);
        }        
        return true;
    }
}