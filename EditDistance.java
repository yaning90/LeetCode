public class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] f = new int[n+1][m+1];
        // initialization
        for(int i=0; i<m+1; i++){
            f[0][i] = i;
        }
        for(int i=0; i<n+1; i++){
            f[i][0] = i;
        }
        
        //main
        for(int i=1; i<n+1; i++){
            for(int j=1;j<m+1;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    f[i][j] = f[i-1][j-1];
                }else{
                    f[i][j]=1+Math.min(f[i-1][j-1],Math.min(f[i][j-1],f[i-1][j]));
                }
            }
        }
        return f[n][m];
    }
}
