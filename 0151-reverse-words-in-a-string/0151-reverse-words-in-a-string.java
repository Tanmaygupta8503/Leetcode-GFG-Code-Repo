class Solution {
    public String reverseWords(String s) {
        String words[] = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(var word : words) {
            if(word.trim().length() > 0){
                sb.insert(0,word);
                sb.insert(0," ");
            }
        }
        return sb.toString().trim();
    }
}