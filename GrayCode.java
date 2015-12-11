public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> answer = new ArrayList<Integer>();
        if( n == 0){
            answer.add(0);
            return answer;
        }
        
        answer = grayCode(n - 1);
        
        for(int i = answer.size() - 1; i >= 0; i--){
            int num = answer.get(i);
            num += 1 << (n - 1);
            answer.add(num);
        }
        return answer;
    }
}
