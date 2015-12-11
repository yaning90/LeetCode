public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    dfs(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid, boolean[][] visited, int row, int col){
        if(row >= grid.length || row < 0 || col >= grid[0].length || col < 0 || grid[row][col] ==                   '0'||visited[row][col] == true){
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row - 1, col); // up
        dfs(grid, visited, row + 1, col); // down
        dfs(grid, visited, row, col - 1); // left
        dfs(grid, visited, row, col + 1); // right
    }
}
