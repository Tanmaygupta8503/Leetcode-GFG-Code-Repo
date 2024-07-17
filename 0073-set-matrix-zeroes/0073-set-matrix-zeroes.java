class Solution {
    public void setZeroes(int[][] matrix) {
        boolean usedRow[] = new boolean[matrix.length];
        boolean usedCol[] = new boolean[matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0 ; j < matrix[0].length ; j ++) {
                if(matrix[i][j] == 0){
                    usedRow[i] = true;
                    usedCol[j] = true;
                }
            }
        }
        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0 ; j < matrix[0].length ; j ++) {
                if(usedRow[i]){
                    for(int k = 0; k < matrix[0].length ; k ++){
                        matrix[i][k] = 0;
                    }
                }
                if(usedCol[j]){
                    for(int k = 0; k < matrix.length ; k ++){
                        matrix[k][j] = 0;
                    }
                }
            }
        }
    }
}