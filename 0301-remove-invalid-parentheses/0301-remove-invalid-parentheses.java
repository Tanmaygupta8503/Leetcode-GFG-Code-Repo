class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> list = new ArrayList<>();
        solve(list , s , 0 , "");
        int max = 0;
        for(var str : list) {
            max = Math.max(max , str.length());
        }
        Set<String> ans = new HashSet<>();
        for(var str : list) {
            if(str.length() == max) {
                ans.add(str);
            }
        }
        return new ArrayList<>(ans);
    }
    void solve(List<String> list , String s , int i, String str){
        if(i >= s.length()) {
            if(isValid(str)) {
                list.add(str);
                return;
            }
            return;
        }
        //include
        if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
            solve(list , s , i + 1 , str + s.charAt(i));
        }
        else{
            // exclude
            solve(list , s , i + 1 , str);
            // include
            solve(list , s , i + 1 , str + s.charAt(i));
        }
    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c >= 'a' && c <= 'z') continue;
            if(c == '[' || c == '{' || c == '('){
                stack.push(c);
            } else {
                if(stack.isEmpty()){
                    return false;
                } else {
                    char temp = stack.pop();
                    if(c == '}' && temp != '{'){
                        return false;
                    } else if(c == ']' && temp != '['){
                        return false;
                    } else if(c == ')' && temp != '('){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}