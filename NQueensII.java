// version 1, use global variables
//
public class Solution {
    public int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0){
            return 0;
        }
        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        
        totalNQueensHelper(answers, cols, n);
        return count;
    }
    // search
    public void totalNQueensHelper(ArrayList<ArrayList<Integer>> answers, ArrayList<Integer> cols,
        int n){
        if(cols.size() == n){
            answers.add(new ArrayList<Integer>(cols));
            count++;
            return;
        }
        for(int col = 0; col < n; col++){
            if(!isValid(cols, col)){
                continue;
            }
            cols.add(col);
            totalNQueensHelper(answers, cols, n);
            cols.remove(cols.size() - 1);
        }
            
    }
    public boolean isValid(ArrayList<Integer> cols, int col){
        int row = cols.size();
        for(int i = 0; i < row; i++){
            if(cols.get(i) == col){
                return false;
            }
            if(i - cols.get(i) == row - col){
                return false;
            }
            if(i + cols.get(i) == row + col){
                return false;
            }
        }
        return true;
    }
}

// version 2, better
public class Solution {
    public static int sum;
    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        placeQueen(usedColumns, 0);
        return sum;
    }
    public void placeQueen(int[] usedColumns, int row) {
        int n = usedColumns.length;
        
        if (row == n) {
            sum ++;
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!isValid(usedColumns, row, i)) {
                continue;
            }
            usedColumns[row] = i;
            placeQueen(usedColumns, row + 1);
        }
    }
    public boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == col) {
                return false;
            }
            if (i - usedColumns[i] == row - col) {
                return false;
            }
            if(i + usedColumns[i] == row + col){
                return false;
            }
        }
        return true;
    }
}

