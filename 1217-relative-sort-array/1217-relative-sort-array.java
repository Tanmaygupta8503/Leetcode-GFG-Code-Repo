class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> remaining = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for (int num : arr2)
            countMap.put(num, 0);
        for (int num : arr1) 
            if (countMap.containsKey(num)) 
                countMap.put(num, countMap.get(num) + 1);
            else 
                remaining.add(num);
        Collections.sort(remaining);
        for (int num : arr2)
            for (int j = 0; j < countMap.get(num); j++)
                result.add(num);
        result.addAll(remaining);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}