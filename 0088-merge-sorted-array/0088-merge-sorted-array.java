class Solution1 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0 ; i < n ; i ++) {
            int val = nums2[i];
            int j = (m + i) - 1;
            while(j >= 0 && nums1[j] > val) {
                nums1[j + 1] = nums1[j];
                j --;
            }
            nums1[j + 1] = val;
        }
    }
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int zero = nums1.length - 1;
        int one = m - 1;
        while(one >= 0) {
            nums1[zero --] = nums1[one --];
        }
        int j=one;
        int i=zero;
        i++;
        j++;
        int ptr = 0;
        while(i < nums1.length && j < n) {
            if(nums1[i] < nums2[j]) {
                nums1[ptr ++] = nums1[i ++];
            }else{
                nums1[ptr ++] = nums2[j ++];
            }
        } 
        while(i < nums1.length) {
            nums1[ptr ++] = nums1[i ++];
        }
        while(j < n) {
            nums1[ptr ++] = nums2[j ++];
        }
    }
}