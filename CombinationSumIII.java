public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(k > 9 || k < 1|| n > 81 || n < 1){
            return answers;
        }
        List<Integer> answer = new ArrayList<Integer>();
        int pos = 0;
        combinationSum3Helper(answers, answer, k, n, pos);
        return answers;
    }
    
    public void combinationSum3Helper(List<List<Integer>> answers, List<Integer> answer,
        int k, int n, int pos){
            
        if(n == 0 && answer.size() == k){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        for(int i = pos; i < 9; i++){
            int num = i + 1;
            if( i!=pos && i == i+1){
                continue;
            }
            if(num > n || answer.size() > k){
                break;
            }
            answer.add(num);
            combinationSum3Helper(answers, answer, k, n - num, i + 1);
            answer.remove(answer.size() - 1);
        }
    }
}
