class Solution {
    public int numTeams(int[] rating) {
        int res = 0;
        for(int j = 0 ; j < rating.length ; j ++) {
            int smaller_left = 0, bigger_left = 0;
            int smaller_right = 0, bigger_right = 0;
            for (int i = j - 1 ; i >= 0 ; i --) {
                if (rating[i] < rating[j]) smaller_left ++ ;
                else if (rating[i] > rating[j]) bigger_left ++ ;
            }
            for (int i = j + 1 ; i < rating.length ; i ++) {
                if (rating[i] < rating[j]) smaller_right ++ ;
                else if (rating[i] > rating[j]) bigger_right ++ ;
            }
            res += smaller_left * bigger_right + bigger_left * smaller_right;
        }
        return res;
    }
}