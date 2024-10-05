class Solution {
    public boolean checkInclusion(String p, String s) {
       
        int[] map = new int[128];
        for (char ch : p.toCharArray()) {
            map[ch]++;
        }
        int beg = 0, end = 0, ctr = p.length();
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0)    
                ctr--;
            if (ctr == 0)
                return true;
            if (end - beg == p.length() && map[s.charAt(beg++)]++ >= 0)  
                ctr++;
        }
        return false; 
    }
}
