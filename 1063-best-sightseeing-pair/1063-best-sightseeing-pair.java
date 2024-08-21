class Solution1 {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE , n = values.length;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = i + 1 ; j < n ; j ++) {
                max = Math.max(max , values[i] + values[j] + i - j);
            }
        }
        return max;
    }
}


class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max1 = values[0];
        int res = Integer.MIN_VALUE;        
        for (int j = 1; j < values.length; j++) {
            res = Math.max(res, max1 + values[j] - j);            
            max1 = Math.max(max1, values[j] + j);
        }
        return res;
    }
}