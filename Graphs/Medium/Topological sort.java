class Solution {
    
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
        
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[adj.size()];
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < adj.size(); i++){
            if(visited[i] == 0){
                dfs(adj, visited, stack, i);
            }
        }
        
        while(!stack.isEmpty()){
            ans.add(stack.pop());
        }
        
        return ans;
    }
}
