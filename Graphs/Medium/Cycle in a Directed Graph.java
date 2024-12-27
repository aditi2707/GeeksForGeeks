class Solution {
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVisited, int src){
        
        visited[src] = 1;
        pathVisited[src] = 1;
        
        for(Integer i: adj.get(src)){
            if(visited[i] == 0){
                if(dfs(adj, visited, pathVisited, i)){
                    return true;
                }
            }
            else{
                if(pathVisited[i] == 1){
                    return true;
                }
            }
        }
        
        pathVisited[src] = 0;
        return false;
    }
    
    
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                if(dfs(adj, visited, pathVisited, i)){
                    return true;
                }
            }
        }
        
        return false;
    }
}
