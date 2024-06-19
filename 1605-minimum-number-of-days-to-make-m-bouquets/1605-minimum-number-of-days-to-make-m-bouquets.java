class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE,  high = 0;
        for(int i : bloomDay) {
            low = Math.min(low , i);
            high = Math.max(high , i);
        }
        int ans = -1;
        while(low <= high) {
            int day = low + (high - low) / 2;
            if(canMakeBouquets(day , bloomDay , m , k)){
                high = day - 1;
                ans = day;
            }else{
                low = day + 1;
            }
        }
        return ans;
    }
    boolean canMakeBouquets(int day , int arr[] , int numOfBouquets , int adjFlower) {
        int bouquets = 0;
        int flowers = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                flowers ++;
                if (flowers == adjFlower) {
                    bouquets ++;
                    flowers = 0;
                    if (bouquets >= numOfBouquets) {
                        return true;
                    }
                }
            } else {
                flowers = 0;
            }
        }
        return false;
    }
}