public class Solution {
    public int trap(int[] height) {
        if(height == null || height.length < 3){
            return 0;
        }
        // find the global maximum
        int global_max_index = findMaxIndex(height);
        // calculate the left trapping water
        int left_max_value = height[0];
        int sum = 0;
        for(int i = 1; i < global_max_index; i++){
            if(height[i] > left_max_value){
                left_max_value = height[i];
            }else{
                sum += left_max_value - height[i];
            }
        }
        // calculate the right trapping water
        int right_max_value = height[height.length - 1];
        for(int i = height.length - 2; i > global_max_index; i--){
            if(height[i] > right_max_value){
                right_max_value = height[i];
            }else{
                sum += right_max_value - height[i];
            }
        }
        return sum;
    }
    public int findMaxIndex(int[] height){
        int max = Integer.MIN_VALUE;
        int max_index = Integer.MIN_VALUE;
        for(int i = 0; i < height.length; i++){
            if(height[i] > max){
                max = height[i];
                max_index = i;
            }
        }
        return max_index;
    }
}
