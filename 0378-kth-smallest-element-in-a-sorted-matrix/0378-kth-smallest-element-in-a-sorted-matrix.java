class Solution {
    public int kthSmallest(int[][] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int j[] : nums){
            for(int i : j) {
                pq.add(i);
                if(pq.size() > k) pq.poll();
            }
        }
        return pq.peek();
    }
}