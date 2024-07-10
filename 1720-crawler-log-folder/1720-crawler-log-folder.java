class Solution {
    public int minOperations(String[] logs) {
        int count = 0;
        for(String s : logs) {
            if(s.equals("./") || (s.equals("../") && count == 0)) continue;
            if(s.equals("../")) count --;
            else{
                count ++;
            }
        }
        return count;
    }
}