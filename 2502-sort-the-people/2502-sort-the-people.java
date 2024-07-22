import java.util.Arrays;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Object[][] arr = new Object[names.length][2];        
        for (int i = 0; i < names.length; i++) {
            arr[i][0] = names[i];
            arr[i][1] = heights[i];
        }        
        Arrays.sort(arr, (a, b) -> (Integer) b[1] - (Integer) a[1]);        
        String[] sortedNames = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            sortedNames[i] = (String) arr[i][0];
        }
        return sortedNames;
    }
}
