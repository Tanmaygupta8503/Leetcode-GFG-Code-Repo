class Solution1 {
    Map<String , Integer> map = new HashMap<>();
    public int maxScore(int[] cardPoints, int k) {
        return solve(cardPoints , 0 , cardPoints.length - 1 , k);
    }
    public int solve(int arr[] , int i , int j , int k) {
        if(k == 0) return 0;
        if(i > j) return 0;
        String key = i + " " + j + " " + k;
        if(map.containsKey(key)) {
            return map.get(key);
        }
        int op1 = arr[i] + solve(arr , i + 1 , j , k - 1);
        int op2 = arr[j] + solve(arr , i , j - 1 , k - 1);
        map.put(key , Math.max(op1 , op2));
        return map.get(key);
    }
}



class Solution{
    public int maxScore(int[] cardPoints, int k) {
        int arrsum = 0;
        for(var i : cardPoints) {
            arrsum += i;
        }
        int window = cardPoints.length - k;
        int ws = 0;
        int sum = 0;
        for(int i = 0 ; i < window ; i ++) {
            sum += cardPoints[i];
        }
        int min = sum;
        for(int we = window ; we < cardPoints.length ; we ++){
            sum += cardPoints[we];
            sum -= cardPoints[ws ++];
            min = Math.min(sum , min);
        }
        return arrsum - min;
    }
}