class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r =sum % k;
            if (!hashMap.containsKey(r))
                hashMap.put(r, i);
            else if ( i - hashMap.get(r) > 1)
                return true;
        }
        return false;
    }
}