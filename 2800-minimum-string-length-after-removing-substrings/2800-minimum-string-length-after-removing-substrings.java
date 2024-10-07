class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && stack.peek() == 'A'){
                if(c == 'B'){
                    stack.pop();
                }
                else{
                    stack.add(c);
                }
                // System.out.println("1" + stack);
            }
            else if(!stack.isEmpty() && stack.peek() == 'C'){
                if(c == 'D'){
                    stack.pop();
                }else{
                    stack.add(c);
                }
                // System.out.println("2" + stack);
            }else{
                stack.add(c);
                // System.out.println("3" + stack);
            }
        }
        return stack.size();
    }
}