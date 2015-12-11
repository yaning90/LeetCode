public class Solution {
    public String addBinary(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int flag = 0;
        String ans = "";
       
        int i = lenA-1;
        int j = lenB-1;
        
        while(i>=0&&j>=0){
            int sum = (int)(a.charAt(i)-'0')+(int)(b.charAt(j)-'0')+flag;
            ans = String.valueOf(sum%2) + ans;
            flag = sum/2;
            i--;
            j--;
        }
        while(i>=0){
            int sum = (int)(a.charAt(i)-'0') +flag;
            ans = String.valueOf(sum%2) + ans;
            flag = sum/2;
            i--;
        }
        while(j>=0){
            int sum = (int)(b.charAt(j)-'0')+flag;
            ans = String.valueOf(sum%2) + ans;
            flag= sum/2;
            j--;
        }
        if(flag>0){
            ans = String.valueOf(flag) + ans;
        }
        return ans;
    }
}
