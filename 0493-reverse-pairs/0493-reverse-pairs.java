class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums , 0 , nums.length - 1);
    }
    private int mergeSort(int nums[] , int i , int j){
        int cnt = 0;
        if(i < j) {
            int mid = i + (j - i) / 2;
            cnt += mergeSort(nums , i , mid);
            cnt += mergeSort(nums , mid + 1 , j);
            cnt += countReversePairs(nums , i , j);
            merge(nums , i , j , mid);
        }
        return cnt;
    }
    private int countReversePairs(int nums[] , int low , int high){
        int mid = low + (high - low) / 2;
        int cnt = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            //until j {mid + 1 to high}
            while (j <= high && nums[i] > 2L * nums[j]) {
                j++;
            }
            cnt += (j - (mid + 1));
        }
        return cnt;
    }
    private void merge(int arr[] , int i , int j , int mid){
        // left = i to mid
        // right = mid to j
        int[] left = new int[mid - i + 1];
        int[] right = new int[j - mid];

        // Copy elements from i to mid into left array
        for (int k = i; k <= mid; k++) {
            left[k - i] = arr[k];
        }
         // Copy elements from mid+1 to j into right array
        for (int k = mid + 1; k <= j; k++) {
            right[k - (mid + 1)] = arr[k];
        }
        // print(left);
        // print(right);
        int l = left.length;
        int r = right.length;
        int k = i;
        i = 0;
        j = 0;
        while(i < l && j < r){
            if(left[i] <= right[j]){
                arr[k ++] = left[i++];
            }else{
                arr[k ++] = right[j++];
            }
        }
        while(i < l) {
            arr[k ++] = left[i++];
        }
        while(j < r) {
            arr[k ++] = right[j++];
        }
    }
    void print(int nums[]){
        Arrays.stream(nums).forEach(System.out::println);
    }
}