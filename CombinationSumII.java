public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return answers;
        }
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(candidates);
        int pos = 0;
        helper(answers, answer, candidates, target, pos);
        return answers;
    }
    
    public void helper(List<List<Integer>> answers, List<Integer> answer, int[] candidates,
        int target, int pos){
        if(target == 0){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        for(int i = pos; i<candidates.length; i++){
            if(candidates[i] > target){
                break;
            }
            if(i != pos && candidates[i] == candidates[i-1]){
                continue;
            }
            answer.add(candidates[i]);
            helper(answers, answer, candidates, target - candidates[i], i+1);
            answer.remove(answer.size() - 1);
        }
    }
}
