class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String , List<String>> map = new HashMap<>();
        for(String str : strs) {
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            if(map.containsKey(key))
                map.get(key).add(str);
            else
                map.put(key , new ArrayList<>(Arrays.asList(str)));
        }
        return new ArrayList<>(map.values());
    }
}