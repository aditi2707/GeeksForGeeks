class Solution {
    public void floydWarshall(int[][] dist) {
        // Code here
        
        // Time Complexity : O(V ^ 3)
        // Self-explanatory
        
        // Space Complexity : O(1)
        // Since all operations are done in-place, SC is constant.
        
        
        int V = dist.length;
        
        for(int k = 0; k < V; k++){
            for(int i = 0; i < V; i++){
                for(int j = 0; j < V; j++){
                    if(dist[i][k] != 100000000 && dist[k][j] != 100000000){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                    
                }
            }
        }
        
        return;
    }
}
