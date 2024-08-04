class Solution {
    public boolean canAliceWin(int[] nums) {
        int sum = 0 ,twosum = 0;
        for(int i : nums) {
            if(i < 10) {
                sum += i;
            }
            else{
                twosum += i;
            }
        }
        return sum != twosum;
    }
}