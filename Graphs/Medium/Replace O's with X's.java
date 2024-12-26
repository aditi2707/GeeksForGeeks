class Solution {
    
    private static void dfs(char[][] grid, int[][] visited, int i, int j){
        
        if(i < 0 || i >= grid.length){
            return;
        }
        if(j < 0 || j >= grid[0].length){
            return;
        }
        
        if(grid[i][j] == 'X' || visited[i][j] == -1){
            return;
        }
        
        visited[i][j] = -1;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
        
        return;
    }
    
    static char[][] fill(char mat[][]) {
        // code here
        
        int[][] visited = new int[mat.length][mat[0].length];
        
        int[] rows = {0, mat.length - 1};
        int[] cols = {0, mat[0].length - 1};
        
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(visited[rows[i]][j] == 0 && mat[rows[i]][j] == 'O'){
                    dfs(mat, visited, rows[i], j);
                }
                else if(visited[rows[i]][j] == 0 && mat[rows[i]][j] == 'X'){
                    visited[rows[i]][j] = 1;
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < cols.length; j++){
                if(visited[i][cols[j]] == 0 && mat[i][cols[j]] == 'O'){
                    dfs(mat, visited, i, cols[j]);
                }
                else if(visited[i][cols[j]] == 0 && mat[i][cols[j]] == 'X'){
                    visited[i][cols[j]] = 1;
                }
            }
        }
        
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 'O' && visited[i][j] != -1){
                    mat[i][j] = 'X';
                }
            }
        }
        
        return mat;
    }
}
