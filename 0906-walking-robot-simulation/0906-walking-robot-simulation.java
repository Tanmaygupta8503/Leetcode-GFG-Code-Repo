class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        HashSet<List<Integer>> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(Arrays.asList(obstacle[0], obstacle[1]));
        }
        int[]point = new int[]{0 , 0};
        int ans = 0;
        int set_drxn = 0;
        for(int i : commands) {
            int cnt = i;
            if(i == -1) {
                set_drxn = (set_drxn + 1) % 4;
                continue;
            }
            else if(i == -2) {
                if(set_drxn == 0) {
                    set_drxn = 3;
                }else{
                    set_drxn --;
                }
                continue;
            }
            while(cnt > 0){
                // System.out.println(point[0] + " " + point[1] + " " + set_drxn);
                if(set_drxn == 0) { // north -> y ++
                    if(set.contains(new ArrayList(List.of(point[0] , point[1] + 1)))){
                        break;
                    }
                    point[1] ++;
                    cnt --;
                }
                else if(set_drxn == 1) { // east -> x ++
                    if(set.contains(new ArrayList(List.of(point[0] + 1 , point[1])))){
                        break;
                    }
                    point[0] ++;
                    cnt --;
                }
                else if(set_drxn == 2) { // south -> y --
                    if(set.contains(new ArrayList(List.of(point[0] , point[1] - 1)))){
                        break;
                    }
                    point[1] --;
                    cnt --;
                }
                else if(set_drxn == 3) { // west -> x --
                    if(set.contains(new ArrayList(List.of(point[0] - 1, point[1])))){
                        break;
                    }
                    point[0] --;
                    cnt --;
                }
            }
            ans = Math.max(ans , point[0] * point[0] + point[1] * point[1]);
        }
        return ans;
    }
}