public class Solution {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int flag = 1; // 表示进位，1即是进位
        for(int i=len-1;i>=0;i--){ // 模拟加法过程，进位为商，留下的为余数
            int sum=digits[i]+flag;
            digits[i] = sum%10;
            flag = sum/10;
        }
        if(flag==0) return digits;
        int[] ans = new int[len+1]; // 若进位不为0 则多出一位阿
        ans[0]=1;
        for(int i=1; i<ans.length;i++){
            ans[i]=0;
        }
        return ans;
        
    }
}
