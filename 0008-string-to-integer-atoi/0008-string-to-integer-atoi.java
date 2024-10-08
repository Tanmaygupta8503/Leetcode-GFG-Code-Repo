class Solution {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        StringBuilder sb = new StringBuilder();
        int sign = 1;
        if(s.charAt(0) == '-') {
            sign = -1;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '+'){
            sign = 1;
            s = s.substring(1);
        }
        long sum = 0;
        for(char c : s.toCharArray()) {
            if(Character.isDigit(c)){
                sum = sum * 10 + c-'0';
            }else{
                break;
            }
            if(sign * sum >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if(sign * sum <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        }
        return (int)(sign * sum);
    }
}