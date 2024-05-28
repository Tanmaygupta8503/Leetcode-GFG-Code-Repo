class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int arr [] = new int [s.length()];
        // make an array of the differece of the s[i] - t[i];
        for(int i = 0 ; i < s.length() ; i ++)
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        // print(arr);
        // apply binary search on the arr who has all the differences 1 ---> sizeof(string)
        int l = 1 , h = s.length() , ans = 0;
        while(l <= h) {
            int mid = (l + h) / 2;
            if(possible(mid , arr , maxCost)) {
                ans = mid;
                l = mid + 1;
            }else {
                h = mid - 1;
            }
        }
        return ans;
    }
    boolean possible(int mid , int[] arr , int cost) {
        int sum = 0 , ws = 0;
        // System.out.println("I m mid " + mid);
        for(int we = 0 ; we < arr.length ; we ++) {
            sum += arr[we];
            if((we - ws + 1) > mid) sum -= arr[ws ++];
            if((we - ws + 1) == mid && cost >= sum) return true; 
        }
        return false;
    }
    void print(int arr[]) {
        for(int c : arr) {
            System.out.println(c);
        }
    }
}
