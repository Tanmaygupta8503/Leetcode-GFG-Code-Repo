class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        for(int i : nums) {
            map.put(i , map.getOrDefault(i , 0) + 1);
        }
        Integer[][] arr = new Integer[map.size()][2];
        int ptr = 0;
        for(var entry : map.entrySet()){
            arr[ptr][0] = entry.getKey();
            arr[ptr++][1] = entry.getValue();
        }
        Comparator<Integer[]> comparator = new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {
                if (b[1] - a[1] > 0) {
                    return -1;
                } else if (b[1] - a[1] < 0) {
                    return 1;
                } else {
                    if (a[0] > b[0]) {
                        return -1;
                    } else if (a[0] < b[0]) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        };
        Arrays.sort(arr , comparator);
        ptr = 0;
        for(Integer i [] : arr) {
            while(i[1] -- > 0) {
                nums[ptr ++] = i[0]; 
            }
        }
        return nums;
    }
}