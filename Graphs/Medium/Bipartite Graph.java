class Solution {
    
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
        
        return bfs(adj, visited);
    }
}
