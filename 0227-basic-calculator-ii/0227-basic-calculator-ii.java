class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        for(int i = 0 ; i < s.length() ; i ++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int val = 0;
                while(i < s.length() && Character.isDigit(s.charAt(i))) {
                    val = val * 10 + s.charAt(i) - '0';
                    ++ i;
                }
                i--;
                if(sign == '+'){
                    stack.add(val);
                }
                else if(sign == '-') {
                    stack.add(-val);
                }
                else if(sign == '/') {
                    int num = stack.pop();
                    stack.push(num / val);
                }
                else if(sign == '*'){
                    int num = stack.pop();
                    stack.push(num * val);
                }
            }else if(ch != ' ') {
                sign = ch;
            }
        }
        int ans = 0;
        while(!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}