class Solution {
    public int heightChecker(int[] heights) {
        int temp[]=new int [heights.length];
        System.arraycopy(heights , 0 , temp , 0 , heights.length);
        int c=0;
        Arrays.parallelSort(temp);
        for(int i = 0 ; i < temp.length ; i ++)
            if(temp[i] != heights[i]) c ++;
        return c;
    }
}