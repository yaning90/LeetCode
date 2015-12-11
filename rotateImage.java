public class Solution {
    public void rotate(int[][] matrix) {
        if(matrix == null || matrix.length == 0 ||matrix[0].length == 0){
            return;
        }
        // inplace rotate
        int n = matrix.length;
        for(int i = 0 ; i < n / 2; i++){
            for(int j = i; j < n - i - 1; j++){
                int tempt = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i]; // 哪一行就是哪一列
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = tempt;
            }
        }
        return;
    }
}
