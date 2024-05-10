class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        int m = nums1.length;
        int n = nums2.length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                if (pq.size() < k) {
                    pq.offer(new int[]{sum, i, j});
                } else if (pq.peek()[0] > sum) {
                    pq.poll();
                    pq.offer(new int[]{sum, i, j});
                } else {
                    break;
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int i = temp[1];
            int j = temp[2];
            result.add(new ArrayList<>(List.of(nums1[i], nums2[j])));
        }
        return result;
    }
}
