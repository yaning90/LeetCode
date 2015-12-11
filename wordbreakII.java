public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null){
            return null;
        }
        List<String> answer = new ArrayList<String>();
        
        List<String> words = new ArrayList<String>();
        
        helper(s, wordDict, words, answer, 0);
        
        return answer;
    }
    
    public void helper(String s, Set<String> wordDict, List<String> words, List<String> answer, int index){
        int len = s.length();
        if(index == len){
            StringBuilder sb = new StringBuilder();
            for(String str : words){
                sb.append(str);
                sb.append(" ");
            }
            
            sb.deleteCharAt(sb.length() - 1);
            answer.add(sb.toString());
            return;
        }
        
        if(!iswordBreak(s.substring(index), wordDict)){
            return;
        }
        
        for(int i = index; i < len; i++){
            String left = s.substring(index, i + 1);
            if(!wordDict.contains(left)){
                continue;
            }
            words.add(left);
            helper(s, wordDict, words, answer, i + 1);
            words.remove(words.size() - 1);
        }
    }
    
    public boolean iswordBreak(String s, Set<String> wordDict){
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i < s.length() + 1; i++){
            for(int j = 0; j < i; j++){
                if(dp[j] == true && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}