class Solution {
    
    private static void topoBfs(ArrayList<ArrayList<Integer>> adj, int[] inDegree, ArrayList<Integer> ans){
        
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < inDegree.length; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }
        
        while(!queue.isEmpty()){
            int poll = queue.poll();
            ans.add(poll);
            
            for(Integer i: adj.get(poll)){
                inDegree[i]--;
                
                if(inDegree[i] == 0){
                    queue.add(i);
                }
            }
        }
        
        return;
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack, int src){
        
        visited[src] = 1;
        
        for(Integer i: adj.get(src)){
            if(visited[i] == 0){
                dfs(adj, visited, stack, i);
            }
        }
        
        stack.push(src);
        
        return;
    }
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        // Your code here
        
        int[] inDegree = new int[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(List<Integer> list: adj){
            for(Integer i: list){
                inDegree[i]++;
            }
        }
        
        topoBfs(adj, inDegree, ans);
        
        return ans;
        
        
        
        
        
        
        
        
        
        // ArrayList<Integer> ans = new ArrayList<>();
        // int[] visited = new int[adj.size()];
        // Stack<Integer> stack = new Stack<>();
        
        // for(int i = 0; i < adj.size(); i++){
        //     if(visited[i] == 0){
        //         dfs(adj, visited, stack, i);
        //     }
        // }
        
        // while(!stack.isEmpty()){
        //     ans.add(stack.pop());
        // }
        
        // return ans;
    }
}
