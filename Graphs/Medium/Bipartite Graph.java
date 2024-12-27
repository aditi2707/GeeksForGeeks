class Solution {
    
    private boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, int src, int color){
        
        visited[src] = color;
        
        for(Integer i: adj.get(src)){
            if(visited[i] == -1){
                if(color == 0){
                    color = 1;
                }
                else{
                    color = 0;
                }
                return dfs(adj, visited, i, color);
                // if(dfs(adj, visited, i, color)){
                //     return true;
                // }
                // else{
                //     return false;
                // }
            }
            else{
                if(visited[i] == color){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private boolean bfs(ArrayList<ArrayList<Integer>> adj, int[] visited){
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 0;
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            
            for(Integer i: adj.get(poll)){
                if(visited[i] == -1){
                    if(visited[poll] == 0){
                        visited[i] = 1;
                    }
                    else{
                        visited[i] = 0;
                    }
                    queue.add(i);
                }
                else{
                    if(visited[i] == visited[poll]){
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        int[] visited = new int[adj.size()];
        Arrays.fill(visited, -1);
        
        visited[0] = 0;
        
        return dfs(adj, visited, 0, 0);
        
        // return bfs(adj, visited);
    }
}
