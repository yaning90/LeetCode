public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return answers;
        }
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(nums);
        int pos = 0;
        subsetsHelper(answers, answer, nums, pos);
        return answers;
    }
    
    public void subsetsHelper(List<List<Integer>> answers, List<Integer> answer, int[] nums, int pos){
        answers.add(new ArrayList<Integer>(answer));
        for(int i = pos; i < nums.length; i++){
            answer.add(nums[i]);
            subsetsHelper(answers, answer, nums, i+1);
            answer.remove(answer.size()-1);
        }
    } 
}
