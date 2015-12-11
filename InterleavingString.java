public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()){
            return false;
        }
        boolean[][] f = new boolean[s1.length()+1][s2.length()+1];
        f[0][0] = true;
        // 
        for(int i=1; i<=s1.length();i++){
            if(s3.charAt(i-1)==s1.charAt(i-1)&&f[i-1][0]){
                f[i][0] = true;
            }
        }
        for(int i=1; i<=s2.length();i++){
            if(s3.charAt(i-1)==s2.charAt(i-1)&&f[0][i-1]){
                f[0][i] = true;
            }
        }
        for(int i=1; i<s1.length()+1; i++){
            for(int j=1; j<s2.length()+1; j++){
                if((s3.charAt(i+j-1)==s1.charAt(i-1)&&f[i-1][j])||(s3.charAt(i+j-1)==s2.charAt(j-1)&&f[i][j-1])){
                    f[i][j] = true;
                }
            }
        }
        return f[s1.length()][s2.length()];
    }
}
