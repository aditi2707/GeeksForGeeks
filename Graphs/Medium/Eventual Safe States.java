class Solution {
    
    private boolean dfs(List<List<Integer>> adj, int[] visited, int[] pathVisited, int src, int[] check){
        
        visited[src] = 1;
        pathVisited[src] = 1;
        
        for(Integer i: adj.get(src)){
            if(visited[i] == 0){
                if(dfs(adj, visited, pathVisited, i, check)){
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
        check[src] = 1;
        
        return false;
    }

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        int[] check = new int[V];
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                dfs(adj, visited, pathVisited, i, check);
            }
        }
        for(int i = 0; i < V; i++){
            if(check[i] == 1){
                ans.add(i);
            }
        }
        
        return ans;
    }
}
