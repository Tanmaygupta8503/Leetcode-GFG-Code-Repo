class Solution {
    public String simplifyPath(String path) {
        String [] words = path.split("/");
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(var word : words){
            if(!stack.isEmpty() && word.equals(".."))    
                stack.pop();
            else if(!word.equals("") && !word.equals(".") && !word.equals(".."))
                stack.push(word);
        }
        if(stack.isEmpty())
            return "/";
        for(var word : stack){
            sb.append("/");
            sb.append(word);
        }
        return sb.toString();
    }
}