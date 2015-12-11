// my first version, use arraylist to store the counts
//
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        if(s.length()==0){
            return count;
        }
        ArrayList<Integer> counts = new ArrayList<>();
        for(int i=0; i<s.length();i++){
            if(s.charAt(i)!=' '){
                count++;
            }else if(s.charAt(i)==' '){
                count=0;
            }
            counts.add(count);
        }
        for(int j=counts.size()-1; j>=0; j--){
            if(s.charAt(j)!=' '){
                return counts.get(j);
            }
        }
        return 0;
    }
}

// second version
public class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        for(int i=s.length()-1;i>=0;i--){
            if(count==0){
                if(s.charAt(i)==' '){
                    continue;
                }else{
                    count++;
                }
            }else{
                if(s.charAt(i)==' '){
                    break;
                }else{
                    count++;
                }
            }
        }
        return count;
    }
}
