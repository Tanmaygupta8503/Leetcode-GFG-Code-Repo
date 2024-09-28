class MyCalendarThree {
TreeMap<Integer , Integer> tmap;
    public MyCalendarThree() {
        tmap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        tmap.put(start , tmap.getOrDefault(start , 0) + 1);
        tmap.put(end , tmap.getOrDefault(end , 0) - 1);
        int cnt = 0, maxCnt = 0;
        // System.out.println(tmap);
        for(int val : tmap.values()){
            cnt += val;
            maxCnt = Math.max(maxCnt , cnt);
        }
        return maxCnt;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */