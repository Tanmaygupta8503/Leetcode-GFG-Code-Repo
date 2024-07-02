class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] count = new int[1001];
        List<Integer> ans = new ArrayList<>();
        Arrays.stream(nums1).forEach(num -> count[num]++);
        Arrays.stream(nums2).forEach(num -> {
            if (count[num] > 0) {
                ans.add(num);
                count[num]--;
            }
        });
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}