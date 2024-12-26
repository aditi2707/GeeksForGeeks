class Solution
{
    
    private int[][] bfs(int[][] grid, int[][] visited, int[][] nearestDistance){
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j, 0});
                }
            }
        }
        
        while(!queue.isEmpty()){
            
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            int dist = poll[2];
            
            nearestDistance[i][j] = dist;
            
            if(i + 1 < grid.length){
                if(visited[i + 1][j] == 0){
                    visited[i + 1][j] = 1;
                    queue.add(new int[]{i + 1, j, dist + 1});
                }
            }
            if(i - 1 >= 0){
                if(visited[i - 1][j] == 0){
                    visited[i - 1][j] = 1;
                    queue.add(new int[]{i - 1, j, dist + 1});
                }
            }
            if(j + 1 < grid[0].length){
                if(visited[i][j + 1] == 0){
                    visited[i][j + 1] = 1;
                    queue.add(new int[]{i, j + 1, dist + 1});
                }
            }
            if(j - 1 >= 0){
                if(visited[i][j - 1] == 0){
                    visited[i][j - 1] = 1;
                    queue.add(new int[]{i, j - 1, dist + 1});
                }
            }
        }
        
        return nearestDistance;
    }
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        int[][] visited = new int[grid.length][grid[0].length];
        int[][] nearestDistance = new int[grid.length][grid[0].length];
        
        return bfs(grid, visited, nearestDistance);
    }
}
