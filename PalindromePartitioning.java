public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> answers = new ArrayList<List<String>>();
        if(s == null){
            return answers;
        }
        List<String> answer = new ArrayList<String>();
        partitionHelper(answers, answer, s, 0);
        return answers;
       
    }
    
    public void partitionHelper(List<List<String>> answers, List<String> answer, String s, int pos){
        if(pos == s.length()){
            answers.add(new ArrayList<String>(answer));
            return;
        }
        for(int i = pos; i < s.length(); i++){
            String prefix = s.substring(pos, i + 1);
            if(!isPalindrome(prefix)){
                continue;
            }
            answer.add(prefix);
            partitionHelper(answers,answer,s, i + 1);//是i+1, 不是pos+1
            answer.remove(answer.size() - 1);
        }
    }
    
    public boolean isPalindrome(String s){
        if(s.length() == 1){
            return true;
        }
        for(int i = 0, j = s.length() - 1; i < j; i++, j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        return true;
    }
}
