public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums.length==0){
            return answers;
        }
        int[] visited = new int[nums.length];
        List<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(nums);
        permuteUniqueHelper(nums,answers,answer,visited);
        return answers;
    }
    public void permuteUniqueHelper(int[] nums, List<List<Integer>> answers, List<Integer> answer, int[] visited){
        if(answer.size()==nums.length){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(visited[i]==1 || (i!=0&&nums[i-1]==nums[i]&&visited[i-1]==1)){
                continue;
            }
            visited[i]=1;
            answer.add(nums[i]);
            permuteUniqueHelper(nums,answers,answer,visited);
            answer.remove(answer.size()-1);
            visited[i]=0;
        }
    }
}
