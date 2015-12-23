public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int[] dp = new int[nums.length];
        // initialization
        for(int i = 0; i < dp.length; i++){
            dp[i] = 1;
        }
        // dp[i], the state is the longest increasing subsequence end at nums[i]
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }
        // find max
        int maxLen = 1;
        for(int k = 1; k < dp.length; k++){
            maxLen = Math.max(maxLen, dp[k]);
        }
        
        return maxLen;
    }
}