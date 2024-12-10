class Solution1 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefixSum = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) == (nums[i - 1] & 1)) {
                prefixSum[i] = prefixSum[i - 1] + 1;
            } else {
                prefixSum[i] = prefixSum[i - 1];
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ans[i] = prefixSum[end] - prefixSum[start] == 0;
        }
        return ans;
    }
}

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] validEndPoint = new int[nums.length];
        int i = 0 , j = 0 , n = nums.length;
        while(i < n && j < n){
            if(j < i) {
                j = i;
            }
            while(j + 1 < n && (nums[j] & 1) != (nums[j + 1] & 1)){
                j ++;
            }
            validEndPoint[i] = j;
            i ++;
        }
        boolean[] ans = new boolean[queries.length];
        for (i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            if(validEndPoint[start] >= end){
                ans[i] = true;
            }
        }
        return ans;
    }
}
