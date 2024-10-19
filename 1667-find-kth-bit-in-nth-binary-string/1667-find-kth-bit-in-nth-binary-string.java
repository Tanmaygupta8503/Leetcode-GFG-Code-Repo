class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder s = new StringBuilder("0");
        while(s.length() < k) {
            StringBuilder temp = new StringBuilder(s);
            s.reverse();
            StringBuilder invert = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char bit = s.charAt(i);
                invert.append(bit == '0' ? '1' : '0');
            }            
            temp.append("1").append(invert);
            s = temp;
        } 
        return s.charAt(k-1);
    }
}