class Solution {
    public int isNegativeWeightCycle(int n, int[][] edges) {
        // code here
        
        // Time Complexity : O(V + V * E + E)
        
        // Space Complexity : O(V)
        
        
        if(edges.length <= 1) {
            return 0;
        }
        
        int[] distance = new int[n];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        distance[edges[0][0]] = 0;
        
        for(int vertex = 0; vertex < n - 1; vertex++){
            for(int[] i: edges){
                int u = i[0];
                int v = i[1];
                int wt = i[2];
                
                if(distance[u] != Integer.MAX_VALUE && 
                distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            int wt = i[2];
                
            if(distance[u] != Integer.MAX_VALUE && 
            distance[u] + wt < distance[v]){
                return 1;
            }
        }
        
        return 0;
    }
}
