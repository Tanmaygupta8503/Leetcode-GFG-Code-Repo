class Solution {
    public int[][] generateMatrix(int n) {
        int arr[][] = new int[n][n];
        int cnt = 1;
        int top = 0 , bottom = arr.length - 1, left = 0 , right = arr[0].length - 1 ;
        while(top <= bottom && right >= left){
            // left to right;
            for(int i = top ; i <= right ; i ++) {
                arr[top][i] = cnt ++;
            }
            top = top + 1;
            // top to bottom
            for(int i = top ; i <= bottom ; i ++) {
                arr[i][right] = cnt ++;
            }
            right = right - 1;
            // right to left
            if(top <= bottom) {
                for(int i = right ; i >= left ; i --) {
                    arr[bottom][i] = cnt ++;
                }
                bottom = bottom - 1;
            }
            // bottom to top
            if(left <= right){
                for(int i = bottom ; i >= top ; i --) {
                    arr[i][left] = cnt ++;
                }
                left = left + 1;
            }
        }
        return arr;
    }
}