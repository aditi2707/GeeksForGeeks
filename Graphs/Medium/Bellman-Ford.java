class Solution {
    public int[] bellmanFord(int V, int[][] edges, int src) {
        // code here
        
        // Time Complexity : O(V + (V * E) + E)
        // Filling the distance array will take O(V) TC. The nested for loops will
        // take (V - 1) * E TC. The last for loop will take O(E) time.
        
        // Space Complexity : O(V)
        // Only the distance[] is used here.
        
        
        int[] distance = new int[V];
        
        Arrays.fill(distance, 100000000);
        
        distance[src] = 0;
        
        for(int i = 0; i < V - 1; i++){
            for(int[] arr: edges){
                int u = arr[0];
                int v = arr[1];
                int wt = arr[2];
                
                if(distance[u] != 100000000 && distance[u] + wt < distance[v]){
                    distance[v] = distance[u] + wt;
                }
            }
        }
        
        for(int[] arr: edges){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];
                
            if(distance[u] != 100000000 && distance[u] + wt < distance[v]){
                return new int[]{-1};
            }
        }
        
        return distance;
    }
}
