public class Solution {
   
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answers = new ArrayList<List<Integer>>();
        if(nums.length==0){
            return null;
        }
        List<Integer> answer = new ArrayList<Integer>();
        int[] visited = new int[nums.length]; // 用visited来标记这个点是否被访问过
        permuteHelper(nums, answers, answer,visited);
        return answers;
        
    }
    public void permuteHelper(int[] nums, List<List<Integer>> answers, List<Integer> answer,int[] visited){
        
        if(answer.size()==nums.length){
            answers.add(new ArrayList<Integer>(answer));
            return;
        }
        for(int i=0;i<nums.length;i++){
              if(visited[i]==1){   // 当然 若不用则 if(answer.contains(nums[i])) continue;
                  continue;
              }
              visited[i]=1;
              answer.add(nums[i]);
              permuteHelper(nums, answers, answer,visited);
              answer.remove(answer.size()-1); // 记得删
              visited[i]=0;  // 记得改标志位
        }
    }
}
