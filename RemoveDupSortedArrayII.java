public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int answer = 0;
        int i, j;
        for(i = 0; i < nums.length;){
            int now = nums[i];
            for(j = i; j < nums.length; j++){
                if(nums[j] != now){
                    break;
                }
                if(j - i < 2){
                    nums[answer] = now; 
                    answer++;
                    
                }
            }
            i = j;
        }
        return answer;
    }
}
