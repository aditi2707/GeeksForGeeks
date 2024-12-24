class Solution {
    
    private void dfs(char[][] grid, int m, int n, int[][] visited){
        
        if(m >= grid.length || m < 0){
            return;
        }
        if(n >= grid[0].length || n < 0){
            return;
        }
        
        if(grid[m][n] == '0' || visited[m][n] == 1){
            return;
        }
        
        visited[m][n] = 1;
        
        dfs(grid, m + 1, n, visited);
        dfs(grid, m + 1, n - 1, visited);
        dfs(grid, m + 1, n + 1, visited);
        dfs(grid, m - 1, n, visited);
        dfs(grid, m - 1, n - 1, visited);
        dfs(grid, m - 1, n + 1, visited);
        dfs(grid, m, n - 1, visited);
        dfs(grid, m, n + 1, visited);
        
        return;
    }
    
    
    
    
    private void bfs(char[][] grid, int m, int n, int[][] visited){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{m, n});
        visited[m][n] = 1;
        
        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            int i = curr[0];
            int j = curr[1];
            
            if(i + 1 < grid.length){
                if(grid[i + 1][j] == '1' && visited[i + 1][j] == 0){
                    visited[i + 1][j] = 1;
                    queue.add(new int[]{i + 1, j});
                }
            }
            if(i + 1 < grid.length && j + 1 < grid[0].length){
                if(grid[i + 1][j + 1] == '1' && visited[i + 1][j + 1] == 0){
                    visited[i + 1][j + 1] = 1;
                    queue.add(new int[]{i + 1, j + 1});
                }
            }
            if(i + 1 < grid.length && j - 1 >= 0){
                if(grid[i + 1][j - 1] == '1' && visited[i + 1][j - 1] == 0){
                    visited[i + 1][j - 1] = 1;
                    queue.add(new int[]{i + 1, j - 1});
                }
            }
            if(i - 1 >= 0){
                if(grid[i - 1][j] == '1' && visited[i - 1][j] == 0){
                    visited[i - 1][j] = 1;
                    queue.add(new int[]{i - 1, j});
                }
            }
            if(i - 1 >= 0 && j + 1 < grid[0].length){
                if(grid[i - 1][j + 1] == '1' && visited[i - 1][j + 1] == 0){
                    visited[i - 1][j + 1] = 1;
                    queue.add(new int[]{i - 1, j + 1});
                }
            }
            if(i - 1 >= 0 && j - 1 >= 0){
                if(grid[i - 1][j - 1] == '1' && visited[i - 1][j - 1] == 0){
                    visited[i - 1][j - 1] = 1;
                    queue.add(new int[]{i - 1, j - 1});
                }
            }
            if(j + 1 < grid[0].length){
                if(grid[i][j + 1] == '1' && visited[i][j + 1] == 0){
                    visited[i][j + 1] = 1;
                    queue.add(new int[]{i, j + 1});
                }
            }
            if(j - 1 >= 0){
                if(grid[i][j - 1] == '1' && visited[i][j - 1] == 0){
                    visited[i][j - 1] = 1;
                    queue.add(new int[]{i, j - 1});
                }
            }
        }
        
        return;
    }
    public int numIslands(char[][] grid) {
        // Code here
        
        int[][] visited = new int[grid.length][grid[0].length];
        int islands = 0;
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    islands++;
                    dfs(grid, i, j, visited);
                    // bfs(grid, i, j, visited);
                }
            }
        }
        
        return islands;
    }
}
