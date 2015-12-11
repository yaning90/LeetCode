public class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Boolean> hm = new HashMap<>(); // 标记这个点有没有被访问过，从而确保了o(n) 因为每个点只被访问了一次
        if(nums==null){
            return 0;
        }
        int ans = 1;
        for(int i=0; i<nums.length; i++){
            hm.put(nums[i],false);
        }
        for(int j=0; j<nums.length; j++){
            if(hm.get(nums[j])){  
                continue;
            }
            // right consecutive sequence
            int temp = nums[j];
            int current_max = 1;
            while(hm.containsKey(temp+1)&&hm.get(temp+1)==false){  // 如果这个点在hm里，并且没被访问过，do following things
                current_max++;
                temp++;
                hm.put(temp,true);  // 标记这个点访问过了
            }
            temp = nums[j];
            // left consecutive sequence
            while(hm.containsKey(temp-1)&&hm.get(temp-1)==false){
                current_max++;
                temp--;
                hm.put(temp,true);
            }
            ans = Math.max(current_max,ans);
        }
        return ans;
        
    }
}
