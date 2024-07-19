class Solution1 {
    Map<String , Integer> map;
    public int maxScore(int[] cardPoints, int k) {
        map = new HashMap<>();
        return solve(cardPoints , k , 0 , cardPoints.length - 1);
    }
    private int solve(int arr[] , int k , int i , int j) {
        if(k == 0) return 0;
        if(i > j) return Integer.MIN_VALUE;
        String key = i + "#" + j + "#" + k;
        if(map.get(key) != null) return map.get(key); 
        int op1 = arr[i] + solve(arr , k - 1 , i + 1 , j);
        int op2 = arr[j] + solve(arr , k - 1 , i , j - 1);
        map.put(key , Math.max(op1 , op2));
        return Math.max(op1 , op2);
    }
}


// find those n - k  elements which are minimum in sum
// then the answer of total sum - min sum of window will be maximum
class Solution{
    public int maxScore(int[] cardPoints, int k) {
        int totalSum = 0;
        for(var i : cardPoints) {
            totalSum += i;
        }
        int window = cardPoints.length - k;
        int ws = 0;
        int sum = 0;
        for(int i = 0 ; i < window ; i ++) {
            sum += cardPoints[i];
        }
        int windowSum = sum;
        for(int we = window ; we < cardPoints.length ; we ++){
            sum += cardPoints[we];
            sum -= cardPoints[ws ++];
            windowSum = Math.min(sum , windowSum);
        }
        return totalSum - windowSum;
    }
}