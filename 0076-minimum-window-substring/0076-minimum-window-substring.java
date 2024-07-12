class Solution {
    public String minWindow(String s, String t) {
        int ws = 0 , we = 0 , minLength = Integer.MAX_VALUE,start = 0 , matched = 0;
        Map<Character , Integer> map = new HashMap<>();
        for(char c : t.toCharArray()) {
            map.put(c , map.getOrDefault(c , 0) + 1);
        }
        for(we = 0 ; we < s.length() ; we ++) {
            char currChar = s.charAt(we);
            if(map.containsKey(currChar)) {
                map.put(currChar , map.get(currChar) - 1);
                if(map.get(currChar) >= 0) {
                    matched += 1;
                }
            }
            if(matched == t.length()) {
                if(minLength > (we - ws + 1)) {
                    minLength = we - ws + 1;
                    start = ws;
                }
                while(matched == t.length()) {
                    if(minLength > (we - ws + 1)) {
                        minLength = we - ws + 1;
                        start = ws;
                    }
                    char leftChar = s.charAt(ws++);
                    if(map.containsKey(leftChar)) {
                        if(map.get(leftChar) == 0) {
                            matched -= 1;
                        }
                        map.put(leftChar , map.get(leftChar) + 1);
                    }
                }
            }
        }
        if(minLength > s.length()) {
            return "";
        }
        return s.substring(start , start + minLength); 
    }
}