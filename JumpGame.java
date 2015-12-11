public class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return true;
        }
        int minJump = 1;
        for(int i = nums.length - 2; i >= 0; i--){
            if(nums[i] >= minJump){
                minJump = 1;
            }else{
                minJump = minJump + 1;
            }
        }
        return nums[0] >= minJump;
    }
}
