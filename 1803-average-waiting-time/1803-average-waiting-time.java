class Solution {
    public double averageWaitingTime(int[][] customers) {
        long sum = 0,idle = 0;
        for (int customer[] : customers) {
            idle = Math.max(customer[0], idle) + customer[1];
            sum += idle - customer[0];
        }
        return (double) sum / customers.length;
    }
}