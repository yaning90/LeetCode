public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length<2){
            return false;
        }
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                int value = hm.get(nums[i]);
                if(i-value<=k){
                    return true;
                }
            }
            hm.put(nums[i],i);
        }
        return false;
    }
}
