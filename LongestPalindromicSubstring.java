public class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        int len = s.length();
        int longestBegin = 0;
        int maxLen = 1;
        boolean isPalindrome[][] = new boolean[len][len];
        // initialize 一个字符
        for(int i = 0; i < len; i++){
            isPalindrome[i][i] = true;
        }
        // 两个字符
        for(int i = 0; i < len - 1 ; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                isPalindrome[i][i + 1] = true;
                longestBegin = i;
                maxLen = 2;
            }
        }
        // main 三个字符，四个字符。。
        for(int length = 2; length < len ; length++){
            for(int i = 0; i + length < len; i++){
                if(isPalindrome[i + 1][i + length - 1] && s.charAt(i) == s.charAt(i + length)){
                    isPalindrome[i][i + length] = true;
                    longestBegin = i;
                    maxLen = length + 1;
                }
            }
        }
        return s.substring(longestBegin, longestBegin + maxLen);
    }
}
