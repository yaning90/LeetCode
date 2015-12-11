public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return answers;
        }
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(nums);
        int pos = 0;
        subsetsWithDupHelper(answers, answer, nums, pos);
        return answers;
    }
    
    public void subsetsWithDupHelper(List<List<Integer>> answers, List<Integer> answer,
        int[] nums, int pos){
        answers.add(new ArrayList<Integer>(answer));
        
        for(int i = pos; i<nums.length; i++){
            if(i != pos && nums[i] == nums[i-1]){
                continue;
            }
            answer.add(nums[i]);
            subsetsWithDupHelper(answers, answer, nums, i+1);
            answer.remove(answer.size() - 1);
        }
    }
}
