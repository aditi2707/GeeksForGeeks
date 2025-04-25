class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        // Time Complexity : O(Elog E)
        // The while loop will run a max of # of edges. The priority queue will 
        // take log E time for sorting and Elog E for every node.
        
        // Space Complexity : O(V + E)
        // The visited[] will have all vertices and queue will have a max of all
        // edges.
        
        
        int[] visited = new int[V];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0]? a[1] - b[1] : a[0] - b[0];
        });
        int sum = 0;
        
        minHeap.add(new int[]{0, 0});
        
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int wt = poll[0];
            int node = poll[1];
            
            if(visited[node] == 1){
                continue;
            }
            
            visited[node] = 1;
            sum += wt;
            
            for(int[] i: adj.get(node)){
                int v = i[0];
                int w = i[1];
                
                minHeap.add(new int[]{w, v});
            }
        }
        
        return sum;
    }
}
