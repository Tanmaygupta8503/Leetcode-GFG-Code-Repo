class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        for(int j = 0 ; j < arr.length ; j ++){
            if(arr[i] != arr[j]){
                i ++;
                arr[i] = arr[j];
            }
        }
        return i + 1;
    }
}