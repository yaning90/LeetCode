public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<String>();
        if(n <= 0){
            return answer;
        }
        getPair(answer, "", n, n);
        return answer;
    }
    public void getPair(List<String> answer, String s, int left, int right){
        if(left > right || left < 0 || right < 0){
            return;
        }
        if(left == 0 && right == 0){
            answer.add(s);
            return;
        }
        getPair(answer, s + '(', left - 1, right);
        getPair(answer, s + ')', left, right - 1);
    }
}
