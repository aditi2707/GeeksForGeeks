// User function Template for Java
class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        
        ArrayList<Integer> ans = new ArrayList<>();
        int[] visited = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = 1;
        
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            ans.add(vertex);
            
            for(Integer i: adj.get(vertex)){
                if(visited[i] != 1){
                    visited[i] = 1;
                    queue.add(i);
                }
            }
        }
        
        return ans;
    }
}
