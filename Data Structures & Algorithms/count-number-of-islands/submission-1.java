class Solution {
    public int numIslands(char[][] grid) {
        
        if(grid == null || grid.length == 0){
            return 0;
        }

        //row col size
        int row = grid.length;
        int col = grid[0].length;
        int numOfIlands = 0;

        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == '1'){
                   numOfIlands++;
                   dfs(grid,r,c);     
                }
            }
        }

        return numOfIlands;
    }

    public void dfs(char[][] grid, int r, int c){
        int row = grid.length;
        int col = grid[0].length;

        //check edge cases / visited
        if(r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
