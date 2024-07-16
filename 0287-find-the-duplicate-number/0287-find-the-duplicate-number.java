//O(nlogn) complexity using sorting and constant extra space
class Solution1 {
    public int findDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 1 ; i < nums.length ; i ++) {
            if(nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }   
        return -1;
    }
}

//O(n) cyclic sort + O(1) extra space
class Solution2 {
    public int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correctIdx = arr[i] - 1;
            if (arr[i] != arr[correctIdx]) {
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                if (i != correctIdx) {
                    return arr[i];
                }
                i++;
            }
        }
        return -1; 
    }
}


class Solution {
    public int findDuplicate(int[] arr) {
        int fast = arr[0];
        int slow = arr[0];
        do{
            fast = arr[arr[fast]];
            slow = arr[slow];
        }while(fast != slow);
        fast = arr[0];
        while(slow != fast) {
            fast = arr[fast];
            slow = arr[slow];
        }
        return fast;
    }
}