class Solution {
    public int minLength(String s) {
        if(s.indexOf("AB") == -1 && s.indexOf("CD") == -1){
            return s.length();
        } 
        if(s.length() > 1 && s.indexOf("AB") >= 0)
            s = s.replace("AB" , "");
        if(s.length() > 1 && s.indexOf("CD") >= 0)
            s = s.replace("CD" , "");
        int len = minLength(s);
        return len;
    }
}