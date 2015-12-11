public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] f = new boolean[s.length()+1];
        f[0] = true;
        for(int i=1;i<=s.length();i++){
            for(int j=0; j<i; j++){
                if(wordDict.contains(s.substring(j,i))&&f[j]==true){
                    f[i]=true;
                }
            }
        }
        return f[s.length()];
    }
}
