class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char i : s.toCharArray()) {
            if(stack.isEmpty()) {
                if(i == '(' || i == '[' || i == '{') {
                    stack.add(i);
                }else{
                    return false;
                }
            }else{
                if((stack.peek() == '[' && i == ']') || (stack.peek() == '{' && i == '}') || (stack.peek() == '(' && i == ')')) {
                    stack.pop();
                }else if(i == '(' || i == '[' || i == '{'){
                    stack.add(i);
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}