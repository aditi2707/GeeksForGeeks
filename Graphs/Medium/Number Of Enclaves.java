class Solution {
    
    private void bfs(int[][] grid, int[][] visited){
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < grid[0].length; i++){
            
            if(grid[0][i] == 1){
                visited[0][i] = 1;
                queue.add(new int[]{0, i});
            }
            
            if(grid[grid.length - 1][i] == 1){
                visited[grid.length - 1][i] = 1;
                queue.add(new int[]{grid.length - 1, i});
            }
        }
        
        for(int i = 0; i < grid.length; i++){
            
            if(grid[i][0] == 1){
                visited[i][0] = 1;
                queue.add(new int[]{i, 0});
            }
            
            if(grid[i][grid[0].length - 1] == 1){
                visited[i][grid[0].length - 1] = 1;
                queue.add(new int[]{i, grid[0].length - 1});
            }
        }
        
        while(!queue.isEmpty()){
            
            int[] poll = queue.poll();
            int i = poll[0];
            int j = poll[1];
            
            if(i + 1 < grid.length){
                if(grid[i + 1][j] == 1 && visited[i + 1][j] == 0){
                    visited[i + 1][j] = 1;
                    queue.add(new int[]{i + 1, j});
                }
            }
            if(i - 1 >= 0){
                if(grid[i - 1][j] == 1 && visited[i - 1][j] == 0){
                    visited[i - 1][j] = 1;
                    queue.add(new int[]{i - 1, j});
                }
            }
            if(j + 1 < grid[0].length){
                if(grid[i][j + 1] == 1 && visited[i][j + 1] == 0){
                    visited[i][j + 1] = 1;
                    queue.add(new int[]{i, j + 1});
                }
            }
            if(j - 1 >= 0){
                if(grid[i][j - 1] == 1 && visited[i][j - 1] == 0){
                    visited[i][j - 1] = 1;
                    queue.add(new int[]{i, j - 1});
                }
            }
        }
        
        return;
    }
    
    private void dfs(int[][] grid, int[][] visited, int i, int j){
        
        if(i < 0 || i >= grid.length){
            return;
        }
        if(j < 0 || j >= grid[0].length){
            return;
        }
        
        if(grid[i][j] == 0 || visited[i][j] == 1){
            return;
        }
        
        visited[i][j] = 1;
        
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
        
        return;
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        
        int[][] visited = new int[grid.length][grid[0].length];
        int enclaves = 0;
        
        bfs(grid, visited);
        
        // for(int i = 0; i < grid[0].length; i++){
            
        //     if(visited[0][i] == 0 && grid[0][i] == 1){
        //         dfs(grid, visited, 0, i);
        //     }
            
        //     if(visited[grid.length - 1][i] == 0 && grid[grid.length - 1][i] == 1){
        //         dfs(grid, visited, grid.length - 1, i);
        //     }
        // }
        
        // for(int i = 0; i < grid.length; i++){
            
        //     if(visited[i][0] == 0 && grid[i][0] == 1){
        //         dfs(grid, visited, i, 0);
        //     }
            
        //     if(visited[i][grid[0].length - 1] == 0 && grid[i][grid[0].length - 1] == 1){
        //         dfs(grid, visited, i, grid[0].length - 1);
        //     }
        // }
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == 0){
                    enclaves++;
                }
            }
        }
        
        return enclaves;
    }
}
