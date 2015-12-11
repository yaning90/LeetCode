public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;  
        for(int i=0; i<prices.length; i++){  
            min = (prices[i]<min)? prices[i]:min;
            max = (prices[i]-min>max)? prices[i]-min:max;
        }
        return max;
    }
}
