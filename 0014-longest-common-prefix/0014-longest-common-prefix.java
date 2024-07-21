class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0]; 
        int minlen = Integer.MAX_VALUE;
        String minstr = "";
        for(String s : strs){
            if(minlen > s.length()) {
                minlen = s.length();
                minstr = s;
            } 
        }
        String ans = "";
        for(int i = 1 ; i <= minstr.length() ; i ++) {
            String temp = minstr.substring(0 , i);
            if(possible(temp , strs , i)){
                ans = temp;
            }
        }
        return ans;
    }
    boolean possible(String temp , String[] strs , int i) {
        for(String s : strs) {
            if(!temp.equals(s.substring(0 , i))){
                return false;
            }
        }
        return true;
    }
}