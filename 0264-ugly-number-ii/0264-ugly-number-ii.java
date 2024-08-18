class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        pq.offer(1L);
        set.add(1L);
        long[] factors = {2, 3, 5};
        long ugly = 1L;
        for (int i = 0; i < n; i++) {
            ugly = pq.poll();
            for (long factor : factors) {
                long nextUgly = ugly * factor;
                if (!set.contains(nextUgly)) {
                    pq.offer(nextUgly);
                    set.add(nextUgly);
                }
            }
        }
        return (int) ugly;
    }
}