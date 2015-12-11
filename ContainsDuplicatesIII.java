public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0 || k < 1){
            return false;
        }
        TreeSet<Integer> window = new TreeSet<>();
        for(int i=0; i<nums.length; i++){
            Integer floor = window.floor(nums[i] + t);
            Integer ceiling = window.ceiling(nums[i] - t);
            if((floor != null) || (ceiling != null && ceiling <= nums[i])){
                return true;
            }
            window.add(nums[i]);
            if(i >= k){
                window.remove(nums[i - k]);
            }
        }
        return false;
    }
}
