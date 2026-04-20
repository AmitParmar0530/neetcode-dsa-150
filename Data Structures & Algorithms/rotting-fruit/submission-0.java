class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();

        int row = grid.length;
        int col = grid[0].length;

        int fresh = 0;
        
        //add all rotten in queue
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                //add all rotte
                if(grid[r][c] == 2){
                    queue.offer(new int[]{r,c});            
                }
                if(grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        int minutes = 0;
        int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};
        //Traverse grid
        while(!queue.isEmpty() && fresh > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                int[] rot = queue.poll();
                int r = rot[0];
                int c = rot[1];

                for(int[] d: direction){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if(nr >= 0 && nc >= 0 && nr < row && nc < col && grid[nr][nc] == 1){
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            minutes++;
        
        }
        
        return fresh == 0 ? minutes : -1;
    }
}
