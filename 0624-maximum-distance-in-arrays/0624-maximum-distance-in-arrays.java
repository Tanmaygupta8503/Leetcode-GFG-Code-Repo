import java.util.List;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);
        int res = 0;
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> array = arrays.get(i);
            int mini = array.get(0);
            int maxi = array.get(array.size() - 1);
            res = Math.max(res, Math.abs(maxi - min));
            res = Math.max(res, Math.abs(max - mini));
            min = Math.min(min, mini);
            max = Math.max(max, maxi);
        }
        return res;
    }
}
