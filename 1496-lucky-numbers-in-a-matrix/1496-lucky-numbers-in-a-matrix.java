class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < m ; j ++) {
                int min = Integer.MAX_VALUE;
                for(int col = 0 ; col < m ; col ++){
                    min = Math.min(min, matrix[i][col]);
                }
                if(min != matrix[i][j]) continue;
                int max = Integer.MIN_VALUE;
                for(int row = 0 ; row < n ; row ++) {
                    max = Math.max(max, matrix[row][j]);
                }
                if(max != matrix[i][j]) continue;
                list.add(matrix[i][j]);
            }
        }
        return list;
    }
}