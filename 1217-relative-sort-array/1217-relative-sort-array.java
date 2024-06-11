import java.util.*;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) 
            map.put(arr2[i], i);
        for (int num : arr1) 
            if (!map.containsKey(num)) 
                map.put(num, 1000000000);
        Comparator<Integer> comparator = (num1, num2) -> {
            if (map.get(num1).equals(map.get(num2))) {
                return Integer.compare(num1, num2);
            } else {
                return Integer.compare(map.get(num1), map.get(num2));
            }
        };
        Integer[] arr1Integer = Arrays.stream(arr1).boxed().toArray(Integer[]::new);
        Arrays.sort(arr1Integer, comparator);
        return Arrays.stream(arr1Integer).mapToInt(Integer::intValue).toArray();
    }
}
