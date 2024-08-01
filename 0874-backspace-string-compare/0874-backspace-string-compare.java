class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z') {
                stk1.add(c);
            }else{
                if(!stk1.isEmpty()) stk1.pop();
            }
        }
        for(char c : t.toCharArray()){
            if(c >= 'a' && c <= 'z') {
                stk2.add(c);
            }else{
                if(!stk2.isEmpty()) stk2.pop();
            }
        }
        if(stk1.size() != stk2.size()) return false;
        while(stk1.size() > 0 && stk2.size() > 0) {
            if(stk1.pop() != stk2.pop()) return false;
        }
        return true;
    }
}