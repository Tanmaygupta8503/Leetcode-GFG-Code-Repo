class Solution {
    public String reverseWords(String s) {
        String words [] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(var word : words) {
            if(!word.trim().equals("")) {
                sb.insert(0 , word);
                sb.insert(0 , " ");
            }
        }
        return sb.toString().trim();
    }
}