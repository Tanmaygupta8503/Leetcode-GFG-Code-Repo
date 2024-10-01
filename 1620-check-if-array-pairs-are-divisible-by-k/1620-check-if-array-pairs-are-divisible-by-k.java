class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> remFreq = new HashMap<>();
        for (int i : arr) {
            int rem = ((i % k) + k) % k;  
            remFreq.put(rem, remFreq.getOrDefault(rem, 0) + 1);
        }
        for (int rem : remFreq.keySet()) {
            int count = remFreq.get(rem);            
            if (rem == 0) {
                if (count % 2 != 0) return false;
            } else {
                int complement = k - rem;
                if (remFreq.getOrDefault(complement, 0) != count){
                    return false;
                }
            }
        }
        return true;
    }
}
