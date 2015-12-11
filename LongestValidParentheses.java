public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int maxLen = 0;
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i); // 把‘（’的位置放进栈中
            }else{
                if(stack.isEmpty()){
                    // the sequence is cut off
                    sum = 0;
                }else{
                    int currentLen = i - stack.pop() + 1;
                    //maxLen = maxLen + t
                    if(stack.isEmpty()){
                        //"()(())"
                        sum = sum + currentLen;
                        maxLen = Math.max(maxLen, sum);
                    }else{
                        //"()(()()"
                        maxLen = Math.max(maxLen, i - stack.peek());
                    }
                }
            }
        }
        return maxLen;
    }
}
