class Solution {
    
    public void dfs(ArrayList<ArrayList<Integer>> adj, int source, int[] visited, ArrayList<Integer> ans){
        
        visited[source] = 1;
        ans.add(source);
        
        for(int i = 0; i < adj.get(source).size(); i++){
            if(visited[adj.get(source).get(i)] != 1){
                dfs(adj, adj.get(source).get(i), visited, ans);
            }
        }
        
        return;
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int[] visited = new int[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfs(adj, 0, visited, ans);
        
        return ans;
    }
}
