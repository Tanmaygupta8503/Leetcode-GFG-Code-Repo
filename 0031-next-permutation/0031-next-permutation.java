class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length; 
        List<Integer> arr = new ArrayList<>();
        for(int i = 0 ; i < n ; i ++) {
            arr.add(nums[i]);
        }
        // Step 1: Find the break point:
        int ind = -1; // break point
        for (int i = n - 2; i >= 0; i--) {
            if (arr.get(i) < arr.get(i + 1)) {
                // index i is the break point
                ind = i;
                break;
            }
        }
        // If break point does not exist:
        if (ind == -1) {
            // reverse the whole array:
            Collections.reverse(arr);
            for(int i = 0 ; i < nums.length ; i ++){
                nums[i] = arr.get(i);
            }
            return;
        }
        // Step 2: Find the next greater element
        //         and swap it with arr[ind]:
        for (int i = n - 1; i > ind; i--) {
            if (arr.get(i) > arr.get(ind)) {
                int tmp = arr.get(i);
                arr.set(i, arr.get(ind));
                arr.set(ind, tmp);
                break;
            }
        }
        // Step 3: reverse the right half:
        List<Integer> sublist = arr.subList(ind + 1, n);
        Collections.reverse(sublist);
        for(int i = 0 ; i < nums.length ; i ++){
            nums[i] = arr.get(i);
        }
        return;
    }
}