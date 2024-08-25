class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int xorAll = IntStream.rangeClosed(0, n)
                              .reduce(0, (a, b) -> a ^ b);
        int xorNums = Arrays.stream(nums)
                            .reduce(0, (a, b) -> a ^ b);
        return xorAll ^ xorNums;
    }
}