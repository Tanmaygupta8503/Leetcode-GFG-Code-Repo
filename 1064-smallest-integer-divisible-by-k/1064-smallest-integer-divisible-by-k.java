class Solution {
    public int smallestRepunitDivByK(int k) {
        int prev = 1;
        int cnt = 1;
        while(prev % k != 0){
            prev = (prev * 10 + 1) % k;
            cnt ++;
            if(cnt > k) return -1;
        } 
        return cnt;
    }
}