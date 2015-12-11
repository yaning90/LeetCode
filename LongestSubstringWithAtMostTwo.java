
// 

public class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        // integer records the times of char's appearance
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int slow = 0, fast = 0;
        int maxLen = 0;
        
       for(;fast < s.length(); fast++){
            char cur = s.charAt(fast);
            if(hm.containsKey(cur)){
                hm.put(cur, hm.get(cur) + 1);
            }else{
                hm.put(cur, 1);
                while(hm.size() > 2){
                    char slowChar = s.charAt(slow);
                    int count = hm.get(slowChar);
                    if(count > 1){
                        hm.put(slowChar, count - 1);
                    }else{
                        hm.remove(slowChar);
                    }
                    slow++;
                }
            }
            
            maxLen = Math.max(maxLen, fast - slow + 1);
        }
        return maxLen;
    }
}
