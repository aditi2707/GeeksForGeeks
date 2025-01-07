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
        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] inDegree = new int[V];
        
        for(int i = 0; i < V; i++){
            list.add(new ArrayList<>());
        }
        
        for(int i = 0; i < V; i++){
            for(Integer j: adj.get(i)){
                list.get(j).add(i);
                inDegree[i]++;
            }
        }
        
        for(int i = 0; i < V; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            
            int poll = queue.poll();
            ans.add(poll);
            
            for(Integer i: list.get(poll)){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        Collections.sort(ans);
        
        return ans;
        
        
        
        
        
        
        
        // List<Integer> ans = new ArrayList<>();
        // int[] visited = new int[V];
        // int[] pathVisited = new int[V];
        // int[] check = new int[V];
        
        // for(int i = 0; i < V; i++){
        //     if(visited[i] == 0){
        //         dfs(adj, visited, pathVisited, i, check);
        //     }
        // }
        // for(int i = 0; i < V; i++){
        //     if(check[i] == 1){
        //         ans.add(i);
        //     }
        // }
        
        // return ans;
    }
}
