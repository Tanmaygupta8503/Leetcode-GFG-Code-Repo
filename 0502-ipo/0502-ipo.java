class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Pair> maxProfit = new PriorityQueue<>((a,b)->(b.profit - a.profit));
        PriorityQueue<Pair> leastCapital = new PriorityQueue<>((a,b)->(a.capital - b.capital));
        for(int i = 0 ; i < profits.length ; i ++){
            leastCapital.add(new Pair(profits[i] , capital[i]));
        }
        for(int i = 0 ; i < k ; i ++){
            while(!leastCapital.isEmpty() && leastCapital.peek().capital <= w){
                maxProfit.offer(leastCapital.poll());
            }
            if(!maxProfit.isEmpty()){
                w += maxProfit.peek().profit;
                maxProfit.poll();
            }
        }
        return w;
    }
}
class Pair{
    int profit , capital;
    Pair(int profit , int capital){
        this.profit = profit;
        this.capital = capital;
    }
}