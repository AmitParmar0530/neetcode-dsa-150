class Solution {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        return dfs(grid, 0, 0, new Integer[rows][cols]);
    }

    public int dfs(int[][] grid, int rows, int cols, Integer[][] memo){
        int m = grid.length;
        int n = grid[0].length;

        //Base case 1: 
        if(rows == m - 1 && cols == n - 1){
            return grid[rows][cols];
        }

        //Base case 2: 
        if(rows >= m || cols >= n){
            return Integer.MAX_VALUE;
        }

        //cache memoisation
        if(memo[rows][cols] != null){
            return memo[rows][cols];
        } 

        //fit case 
        int moveDown = dfs(grid, rows + 1, cols, memo);
        int moveRight = dfs(grid,rows, cols + 1,memo);
        int result = grid[rows][cols] + Math.min(moveDown, moveRight);

        memo[rows][cols] = result;

        return result;
    }
}