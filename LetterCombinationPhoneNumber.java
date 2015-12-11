public class Solution {
    String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
        List<String> answers = new ArrayList<String>();
        if(digits == null || digits.length == 0){
            return answers;
        }
        StringBuilder answer = new StringBuilder();
        helper(answers, answer, digits, 0);
        return answers;
    }
    
    public void helper(List<String> answers, StringBuilder answer, String digits, int index){
        
        if(answer.length() == digits.length()){
            answers.add(answer.toString());
            return;
        }
        
        String s = map[digits.charAt(index) - '0'];
        for(int i = 0; i < s.length(); i++){
            answer.append(s.charAt(i));
            helper(answers, answer, digits, index+1);
            answer.deleteCharAt(answer.length() - 1);
        }
    }
}
