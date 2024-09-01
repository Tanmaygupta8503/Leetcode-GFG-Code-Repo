class Solution {
    public int maxProfit(int[] prices) {
        int buy_price = prices[0];
        int profit = 0;
        for(int i : prices)
            if(i < buy_price) buy_price = i;
            else profit = Math.max(profit , i - buy_price);
        return profit;
    }
}