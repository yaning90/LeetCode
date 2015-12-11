public class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        int i = 0, j = s.length() -1;
        while(i < j){
            while(!isCharacter(s.charAt(i)) && i < s.length() - 1){
                i++;
            }
            while(!isCharacter(s.charAt(j)) && j > 0){
                j--;
            }
            if(i == s.length() -1 || j == 0){
                return true;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }
    
    public boolean isCharacter(char c){
        return Character.isDigit(c) || Character.isLetter(c); 
}
