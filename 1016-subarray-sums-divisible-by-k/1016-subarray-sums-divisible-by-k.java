class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count[] = new int [ k ];
        int sum = 0 ;
        for(int x : nums){
            sum += (x % k + k) % k;
            count[sum % k]++;
        }
        int res = count[0];
        for(int c : count){
            res += (c * (c - 1)) / 2;
        }
        return res;
    }
}