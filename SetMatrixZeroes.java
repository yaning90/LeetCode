public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        // search "0"
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean row0_zero = false, col0_zero = false;
        for(int j = 0; j < cols; j++){
            if(matrix[0][j] == 0){
                row0_zero = true;
            }
        }
        for(int i = 0; i < rows; i++){
            if(matrix[i][0] == 0){
                col0_zero = true;
            }
        }
        for(int i = 0; i < rows ; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                   
                }
            }
        }
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(row0_zero){
            for(int j = 0; j < cols; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0_zero){
            for(int i = 0; i < rows; i++){
                matrix[i][0] = 0;
            }
        }
    }
}
