class Solution {
    public int minimumOperations(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int duplicates = 0;
        for (int num : nums) {
            int freq = freqMap.getOrDefault(num, 0);
            freqMap.put(num, freq + 1);
            if (freq + 1 == 2) duplicates++;
        }
        int steps = 0;
        int i = 0;
        while (i < nums.length && duplicates > 0) {
            int removed = 0;
            for (int j = i; j < nums.length && removed < 3; j++) {
                int num = nums[j];
                if (freqMap.containsKey(num)) {
                    int freq = freqMap.get(num);
                    if (freq > 1) {
                        freqMap.put(num, freq - 1);
                        removed ++;
                        if (freq - 1 == 1) duplicates --;
                    } else if (freq == 1) {
                        freqMap.remove(num);
                        removed ++;
                    }
                }
            }
            steps ++;
            i += 3;
        }
        return steps;
    }
}
