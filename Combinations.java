public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(k <= 0 || n <= 0){
            return answers;
        }
        List<Integer> answer = new ArrayList<Integer>();
        combineHelper(answers, answer, n, k, 0);
        return answers;
    }
    
    public void combineHelper(List<List<Integer>> answers, List<Integer> answer, int n, int k, 
        int pos){
        if(answer.size() == k){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        for(int i = pos; i < n; i++){
            
            answer.add(i + 1);
            combineHelper(answers, answer, n, k, i+1); 
            answer.remove(answer.size() - 1);
        }
    }
}
