// DP
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        int[] sum = new int[len];
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        sum[0] = nums[0];
        sum[1] = nums[1];
        sum[2] = nums[0]+nums[2];
        if(len==3) return Math.max(sum[1],sum[2]);
        for(int i=3; i<len; i++){
            sum[i] = Math.max(sum[i-3],sum[i-2])+nums[i];
        }
        return Math.max(sum[len-1],sum[len-2]);
    }
}
// smart!!
public class Solution {
    public int rob(int[] nums) {
        int last = 0;
        int now = 0;
        for(int i=0; i<nums.length;i++){
            int temp = now;
            now = Math.max((nums[i]+last),temp);
            last =temp;
        }
        return now;
    }
}
