class Solution {
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int source, int[] visited){
        
        visited[source] = 1;
        
        for(int i = 0; i < adj.get(source).size(); i++){
            if(visited[i] == 0 && adj.get(source).get(i) == 1){
                dfs(adj, i, visited);
            }
        }
        
        return;
    }
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        
        int[] visited = new int[V];
        int ans = 0;
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                ans++;
                dfs(adj, i, visited);
            }
        }
        
        return ans;
    }
};
