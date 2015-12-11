public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        // iterate the first string
        String ans = "";
        for(int i=0; i<strs[0].length(); i++){
            // iterate string array
            for(int j=1; j<strs.length; j++){
                if(strs[j].length()<i+1||strs[j].charAt(i)!=strs[0].charAt(i){// 当前字符串床度小于要比较的prefix的长度，或者这个字符不等，则返回答案了
                    return ans;
                }
            }
            ans = ans + strs[0].charAt(i);
        }
        return ans;
    }
}
