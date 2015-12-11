public class Solution {
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        Queue<Point> queue = new LinkedList<Point>();
        int rows = board.length;
        int cols = board[0].length;
        // find 'o' on the edges 
        for(int r = 0; r < rows; r++){
            if(board[r][0] == 'O'){
                board[r][0] = '1';
                queue.add(new Point(r, 0));
            }
            if(board[r][cols - 1] == 'O'){
                board[r][cols - 1] = '1';
                queue.add(new Point(r, cols - 1));
            }
        }
        for(int col = 0; col < cols; col++){
            if(board[0][col] == 'O'){
                board[0][col] = '1';
                queue.add(new Point(0, col));
            }
            if(board[rows - 1][col] == 'O'){
                board[rows - 1][col] = '1';
                queue.add(new Point(rows - 1, col));
            }
        }
        // bfs search for the adjacent O
        while(!queue.isEmpty()){
            Point p = queue.poll();  
            int x = p.x;
            int y = p.y;
            if(x - 1 >= 0 && board[x - 1][y] == 'O'){
                board[x - 1][y] = '1';
                queue.add(new Point(x - 1, y));
            }
            if(x + 1 <= rows - 1 && board[x + 1][y] == 'O'){
                board[x + 1][y] = '1';
                queue.add(new Point(x + 1, y));
            }
            if(y - 1 >= 0 && board[x][y - 1] == 'O'){
                board[x][y - 1] = '1';
                queue.add(new Point(x, y - 1));
            }
            if(y + 1 <= cols - 1 && board[x][y + 1] == 'O'){
                board[x][y + 1] = '1';
                queue.add(new Point(x, y + 1));
            }
        }
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X'; 
                }
                if(board[i][j] == '1'){
                    board[i][j] = 'O';
                }
            }
        }
    }
}
