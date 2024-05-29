class Solution1 {
    public int numSteps(String s) {
        if(s.equals("1") || s.length() == 0 || s.equals("0")) return 0;
        if(s.charAt(s.length() - 1) == '0') {
            return 1 + numSteps(s.substring(0 , s.length() - 1));
        } 
        else{
            return 1 + numSteps(convert(s , "1"));
        }
    }
    String convert(String binary1 , String binary2) {
        int maxLength = Math.max(binary1.length(), binary2.length());
        binary1 = String.format("%" + maxLength + "s", binary1).replace(' ', '0');
        binary2 = String.format("%" + maxLength + "s", binary2).replace(' ', '0');
        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = maxLength - 1; i >= 0; i--) {
            int bit1 = binary1.charAt(i) - '0';
            int bit2 = binary2.charAt(i) - '0';
            int sum = bit1 + bit2 + carry;
            result.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) {
            result.append(carry);
        }
        result.reverse();
        return result.toString();
    } 
}

class Solution2 {
    private void divideByTwo(StringBuilder s) {
        s.deleteCharAt(s.length() - 1);
    }
    private void addOne(StringBuilder s) {
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) != '0') {
            s.setCharAt(i, '0');
            i--;
        }
        if (i < 0) s.insert(0, '1');
        else s.setCharAt(i, '1');
    }
    public int numSteps(String s) {
        StringBuilder str = new StringBuilder(s);
        int step = 0;
        while (str.length() > 1) {
            int n = str.length();
            if (str.charAt(n - 1) == '0') divideByTwo(str);
            else addOne(str);
            step ++;
        }
        return step;
    }
}

class Solution{
    public int numSteps(String s) {
        int carry = 0 , step = 0;
        for(int i = s.length() - 1 ; i >= 1 ; i --) {
            step ++;
            if(((s.charAt(i) - '0') + carry) % 2 == 1) {
                step ++;
                carry = 1;
            }
        }
        return step + carry;
    }
}