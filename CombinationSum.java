public class Solution public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0){
            return answers;
        }
        Arrays.sort(candidates);
        List<Integer> answer = new ArrayList<Integer>();
        int pos = 0;
        combinationSumHelper(answers, answer, candidates, target, pos);
        return answers;
    }
    
    public void combinationSumHelper(List<List<Integer>> answers, List<Integer> answer, 
        int[] candidates, int target, int pos){
            
        if(target == 0){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        
       
        for(int i = pos; i < candidates.length; i++){
            
            if(candidates[i] > target){
                break;
            }
            
            if(i != pos && candidates[i] == candidates[i-1]){
                continue;
            }
            
            answer.add(candidates[i]);
            combinationSumHelper(answers, answer, candidates, target - candidates[i], i);
            answer.remove(answer.size() - 1);
        }
        
    }
}

// 可以不断取自己，所以是i，若是必须从下一个开始取，则是i+1
// 若不加去重语句则 ［1，1］1 返回［［1］，［1］］
