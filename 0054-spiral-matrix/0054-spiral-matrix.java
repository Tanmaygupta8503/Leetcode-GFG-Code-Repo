class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> arr = new ArrayList<>();
        int top = 0 , bottom = matrix.length - 1, left = 0 , right = matrix[0].length - 1 ;
        while(top <= bottom && right >= left){
            // left to right;
            for(int i = top ; i <= right ; i ++) {
                arr.add(matrix[top][i]);
            }
            top = top + 1;
            // top to bottom
            for(int i = top ; i <= bottom ; i ++) {
                arr.add(matrix[i][right]);
            }
            right = right - 1;
            // right to left
            if(top <= bottom) {
                for(int i = right ; i >= left ; i --) {
                    arr.add(matrix[bottom][i]);
                }
                bottom = bottom - 1;
            }
            // bottom to top
            if(left <= right){
                for(int i = bottom ; i >= top ; i --) {
                    arr.add(matrix[i][left]);
                }
                left = left + 1;
            }
        }
        return arr;
    }
}