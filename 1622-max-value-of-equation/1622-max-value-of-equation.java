class Solution1 {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < points.length ; i ++) {
            for(int j = i + 1 ; j < points.length ; j ++) {
                int x1 = points[i][0];
                int y1 = points[i][1];
                int x2 = points[j][0];
                int y2 = points[j][1];
                if(Math.abs(x1 - x2) > k) {
                    break;
                }
                max = Math.max(max,y1 + y2 + Math.abs(x1 - x2));
            }
        }
        return max;
    }
}



class Solution {
    public int findMaxValueOfEquation(int[][] points, int k) {
        int max = Integer.MIN_VALUE;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i = 0 ; i < points.length ; i ++) {
            while((!pq.isEmpty()) && points[i][0] - pq.peek()[1] > k) pq.poll();
            if(!pq.isEmpty()){
                max = Math.max(max , points[i][0] + points[i][1] + pq.peek()[0]);
            }
            pq.add(new int[]{points[i][1] - points[i][0] , points[i][0]});
        }
        return max;
    }
}