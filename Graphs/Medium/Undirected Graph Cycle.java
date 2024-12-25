class Solution {
    
    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int src){
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, -1});
        visited[src] = 1;
        
        while(!queue.isEmpty()){
            int poll[] = queue.poll();
            int node = poll[0];
            int parent = poll[1];
            
            for(Integer i: adj.get(node)){
                if(visited[i] == 0){
                    queue.add(new int[]{i, node});
                    visited[i] = 1;
                }
                else if(parent != i){
                    return true;
                }
            }
        }
        
        return false;
    }
    
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int[] visited = new int[adj.size()];
        
        for(int i = 0; i < adj.size(); i++){
            if(visited[i] == 0){
                if(bfs(adj, visited, i)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
