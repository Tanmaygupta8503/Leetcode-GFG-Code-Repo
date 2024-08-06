class Solution {
    public int minimumPushes(String word) {
        TreeMap<Character, Integer> tmap = new TreeMap<>();  
        for(char c : word.toCharArray()){
            tmap.put(c , tmap.getOrDefault(c , 0) + 1);
        }
        List<Map.Entry<Character, Integer>> entryList = new ArrayList<>(tmap.entrySet());
        Collections.sort(entryList , (a,b) -> b.getValue() - a.getValue());
        // System.out.println(entryList);
        int ctr = 8;
        int sum = 0;
        int mul = 1;
        for(var entry : entryList){
            int val = entry.getValue();
            ctr --;
            sum += (val * mul);
            if(ctr == 0) {
                ctr = 8;
                mul ++;
            }
        }
        return sum;
    }
}