class Solution1 {
    public int subarraySum(int[] nums, int k) {
        //prefix sum
        for(int i = 1 ; i < nums.length ; i++) {
            nums[i] += nums[i - 1]; 
        } 
        int cnt = 0;
        for(int i = 0 ; i < nums.length ; i ++) {
            for(int j = i ; j < nums.length ; j ++) {
                int sum = 0;
                if(i == 0){
                    sum = nums[j];
                }else{
                    sum = nums[j] - nums[i - 1];
                }
                if(sum == k) cnt ++;
            }
        }
        return cnt;
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        //prefix sum
        int prefixSum = 0 , cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0 , 1);
        for(int i = 0 ; i < nums.length ; i++) {
            prefixSum += nums[i];
            cnt += map.get(prefixSum - k) != null ? map.get(prefixSum - k) : 0;
            map.put(prefixSum , map.getOrDefault(prefixSum , 0) + 1);
        } 
        return cnt;
    }
}