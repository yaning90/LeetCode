// version 2
public class Solution {
    public int climbStairs(int n) {
        if(n == 0||n == 1||n == 2){
            return n;
        }
        int last = 1;
        int lastlast = 1;
        int now = 0;
        for(int i=2; i <= n; i++){
            now = last+lastlast;
            lastlast = last;
            last = now;
        }
        return now;
        
    }
}



// version 1
public class Solution {
    public int climbStairs(int n) {
        if(n==0||n==1||n==2){
            return n;
        }
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        steps[2] = 3;
        for(int i=3; i<n; i++){
            steps[i] = steps[i-1]+steps[i-2];
        }
        return steps[n-1];
        
    }
}


