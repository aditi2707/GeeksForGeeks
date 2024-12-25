class Solution {
    
    private int bfs(int[][] grid, int[][] visited){
        
        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        int fresh = 0, rotten = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j, 0});
                    visited[i][j] = 2;
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            while(size > 0){
                int[] poll = queue.poll();
                int i = poll[0];
                int j = poll[1];
                int t = poll[2];
                
                time = Math.max(time, t);
                
                if(i + 1 < grid.length){
                    if(grid[i + 1][j] == 1 && visited[i + 1][j] != 2){
                        queue.add(new int[]{i + 1, j, t + 1});
                        visited[i + 1][j] = 2;
                        rotten++;
                    }
                }
                if(i - 1 >= 0){
                    if(grid[i - 1][j] == 1 && visited[i - 1][j] != 2){
                        queue.add(new int[]{i - 1, j, t + 1});
                        visited[i - 1][j] = 2;
                        rotten++;
                    }
                }
                if(j + 1 < grid[0].length){
                    if(grid[i][j + 1] == 1 && visited[i][j + 1] != 2){
                        queue.add(new int[]{i, j + 1, t + 1});
                        visited[i][j + 1] = 2;
                       rotten++;
                    }
                }
                if(j - 1 >= 0){
                    if(grid[i][j - 1] == 1 && visited[i][j - 1] != 2){
                        queue.add(new int[]{i, j - 1, t + 1});
                        visited[i][j - 1] = 2;
                       rotten++;
                    }
                }
                
                size--;
            }
            
        }
        
        if(fresh != rotten){
            return -1;
        }
        
        return time;
    }
    
    
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] mat) {
        // Code here
        
        int[][] visited = new int[mat.length][mat[0].length];
        
        int ans = bfs(mat, visited);
        
        // for(int i = 0; i < mat.length; i++){
        //     for(int j = 0; j < mat[0].length; j++){
        //         if(mat[i][j] == 1 && visited[i][j] != 2){
        //             return -1;
        //         }
        //     }
        // }
        
        return ans;
    }
}
