class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char i : s.toCharArray()) {
            if(!stack.isEmpty() 
                && (
                    (stack.peek() == '(' && i == ')') || 
                    (stack.peek() == '{' && i == '}') || 
                    (stack.peek() == '[' && i == ']'))
                ) {
                    stack.pop();
            }
            else{
                stack.add(i);
            }
        } 
        return stack.isEmpty();
    }
}