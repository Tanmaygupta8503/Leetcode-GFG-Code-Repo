class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: Find the XOR of all the elements in the array.
        int xor = 0;
        for (int i : nums) xor ^= i;

        // Step 2: Find a set bit in the result of XOR (rightmost set bit).
        int mask = 1;
        while ((xor & mask) == 0) mask <<= 1;
        
        // Step 3: Partition the array elements into two groups and find the unique numbers.
        
        int x = 0, y = 0;
        for (int i : nums)
            if ((i & mask) == 0) x ^= i;  // XOR of the first group
            else y ^= i;  // XOR of the second group
        
        return new int[]{x, y};
    }
}
