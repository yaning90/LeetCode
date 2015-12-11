public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<List<String>>();
        if(n <= 0){
            return answers;
        }
        solveNQueensHelper(answers, new ArrayList<Integer>(), n);
        return answers;
    }
    
    public void solveNQueensHelper(List<List<String>> answers, ArrayList<Integer> cols, int n){
        if(cols.size() == n){
            answers.add(drawChessBoard(cols));//2 -> [. . Q .]
            return;
        }
        for(int col = 0; col < n; col++){
            if(!isValid(cols, col)){
                continue;
            }
            cols.add(col);
            solveNQueensHelper(answers, cols, n);
            cols.remove(cols.size() - 1);
        }
    }
    
    public boolean isValid(ArrayList<Integer> cols, int col){
        int row = cols.size();
        for(int i = 0; i < row; i++){
            // same colum
            if(cols.get(i) == col){
                return false;
            }
            // from left-top to right-bottom
            if(i - cols.get(i) == row - col){
                return false;
            }
            if(i + cols.get(i) == row + col){
                return false;
            }
        }
        return true;
        
    }
    public List<String> drawChessBoard(ArrayList<Integer> cols){
        List<String> answer = new ArrayList<String>();
        for(int i = 0; i < cols.size(); i++){
            String str = "";
            for(int j = 0; j < cols.size(); j++){
                if(cols.get(i) == j){
                    str += "Q";
                }else{
                    str += ".";
                }
            }
            answer.add(str);
        }
        return answer;
    }
}
