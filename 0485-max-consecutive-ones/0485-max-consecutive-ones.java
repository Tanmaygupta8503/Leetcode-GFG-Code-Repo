class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0 , cnt = 0;
        for(int i : nums) {
            if(i == 1) {
                cnt ++;
            }else{
                cnt = 0;
            }
            max = Math.max(max , cnt);
        }
        return max;
    }
}