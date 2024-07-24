class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i : nums) {
            String str = i +"";
            int map = 0;
            for(int j = 0 ; j < str.length() ; j ++) {
                map = map * 10 + mapping[str.charAt(j) - '0'];
            }
            list.add(Arrays.asList(i , map));
        }
        Collections.sort(list , (a,b) -> a.get(1) - b.get(1));
        int [] ans = new int[nums.length];
        int ptr = 0;
        for(var i : list) {
            ans[ptr ++] = i.get(0);
        }
        return ans;
    }
}