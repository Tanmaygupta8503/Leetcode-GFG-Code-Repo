class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        for(int i = 1 ; i < nums.length; i ++) {
            nums[i] += nums[i - 1];
        }
        int cnt = 0 , n = nums.length;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = i ; j < n ; j ++) {
                int sum = i == 0 ? nums[j] : nums[j] - nums[i - 1];
                if(sum % k == 0) cnt ++;
            }
        }
        return cnt;
    }
}
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cnt = 0 , sum = 0 , rem = 0;
        Map<Integer , Integer> map = new HashMap<>();
        map.put(0 , 1); // add zero sum subarray in map
        for(int i : nums ){
            sum += i; // cumulative sum
            // calc remainder
            rem = sum % k; // modifiying negative sum
            if(rem < 0) {
                rem += k;
            }
            if(map.containsKey(rem)) {
                cnt += map.get(rem);
                // update map
                map.put(rem , map.get(rem) + 1);
            }else {
                // put a entry in map
                map.put(rem , 1);
            }
        }
        return cnt;
    }
}