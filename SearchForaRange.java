public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] answer = {-1, -1};
        if(nums == null || nums.length == 0){
            return answer;
        }
        int start = 0;
        int end = nums.length - 1;
        // find the first position of target
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target){
            answer[0] = start;
        }else if(nums[end] == target){
            answer[0] = end;
        }else{
            answer[0] = -1;
        }
        // find the last position of target
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                start = mid;
            }else if(nums[mid] > target){
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[end] == target){
            answer[1] = end;
        }else if(nums[start] == target){
            answer[1] = start;
        }else{
            answer[1] = -1;
        }
        
        return answer;
    }
}
