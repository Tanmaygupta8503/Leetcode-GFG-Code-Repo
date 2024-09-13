class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int total_xor = arr[0];
        int n = arr.length;
        int prefix_xor[] = new int[n];
        int suffix_xor[] = new int[n];
        prefix_xor[0] = arr[0];
        suffix_xor[n - 1] = arr[n - 1];
        for(int i = 1 ; i < n ; i ++) {
            total_xor ^= arr[i];
            prefix_xor[i] = prefix_xor[i - 1] ^ arr[i];
        }
        for(int i = n - 2 ; i >= 0 ; i --) {
            suffix_xor[i] = suffix_xor[i + 1] ^ arr[i];
        }
        for(int i : suffix_xor) {
            System.out.print(i + " ");
        }
        System.out.println();
        for(int i : prefix_xor) {
            System.out.print(i + " ");
        }
        int ptr = 0;
        int ans[] = new int[queries.length];
        for(int [] query : queries) {
            int i = query[0];
            int j = query[1];
            // System.out.println(i + " " + j);
            if(i == 0){
                ans[ptr] = prefix_xor[j];
            }
            else if(i == j) {
                ans[ptr] = arr[i];
            } else {
                if(j < n - 1){
                    ans[ptr] = suffix_xor[j + 1];
                    // System.out.println("this is suffix[3]" + suffix_xor[j + 1] + " this is total_xor" + total_xor);
                }
                ans[ptr] ^= total_xor ^ prefix_xor[i - 1];
            }
            ptr ++;
        }
        return ans;
    }
}