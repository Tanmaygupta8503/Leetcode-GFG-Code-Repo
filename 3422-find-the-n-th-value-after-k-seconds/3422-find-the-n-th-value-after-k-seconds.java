class Solution {
    public int valueAfterKSeconds(int n, int k) {
        int arr[] = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            arr[i] = 1;
        }
        while(k -- > 0) {
            prefixSum(arr);
        }
        return arr[n - 1];
    }
    void prefixSum(int arr[]) {
        long mod = (long)(1e9 + 7);
        for(int i = 1 ; i < arr.length; i ++) {
            long a = arr[i]*1L;
            long b = arr[i - 1]*1l;
            long c = (a + b) % mod;
            arr[i] = (int)c;
        }
    }
}