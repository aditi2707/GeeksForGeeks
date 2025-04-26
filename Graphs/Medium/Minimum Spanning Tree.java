class Solution {
    
    private static int find(int[] par, int a){
        while(par[a] != a){
            a = par[a];
        }
        
        return a;
    }
    
    
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        
        // ** Kruskal's Algorithm **
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0]? a[1] - b[1] : a[0] - b[0];
        });
        int[] parent = new int[V];
        int[] rank = new int[V];
        int sum = 0;
           
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                int[] arr = adj.get(i).get(j);
                minHeap.add(new int[]{arr[1], i, arr[0]});
            }
        }
           
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
           
        while(!minHeap.isEmpty()){
            int[] poll = minHeap.poll();
            int wt = poll[0];
            int u = poll[1];
            int v = poll[2];
               
            int ult_u = find(parent, u);
            int ult_v = find(parent, v);
               
            if(ult_u != ult_v){
                sum += wt;
                    if(rank[ult_u] == rank[ult_v]){
                        parent[ult_v] = ult_u;
                        rank[ult_u] += 1;
                    }
                    else if(rank[ult_u] < rank[ult_v]){
                        parent[ult_u] = ult_v;
                    }
                    else{
                        parent[ult_v] = ult_u;
                    }
                }
            }
           
            return sum;
        
        
        
        
        
        
    
    //     // ** Prims Algorithm **
        
    //     // Time Complexity : O(Elog E)
    //     // The while loop will run a max of # of edges. The priority queue will 
    //     // take log E time for sorting and Elog E for every node.
        
    //     // Space Complexity : O(V + E)
    //     // The visited[] will have all vertices and queue will have a max of all
    //     // edges.
        
        
    //     int[] visited = new int[V];
    //     PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
    //         return a[0] == b[0]? a[1] - b[1] : a[0] - b[0];
    //     });
    //     int sum = 0;
        
    //     minHeap.add(new int[]{0, 0});
        
    //     while(!minHeap.isEmpty()){
    //         int[] poll = minHeap.poll();
    //         int wt = poll[0];
    //         int node = poll[1];
            
    //         if(visited[node] == 1){
    //             continue;
    //         }
            
    //         visited[node] = 1;
    //         sum += wt;
            
    //         for(int[] i: adj.get(node)){
    //             int v = i[0];
    //             int w = i[1];
                
    //             minHeap.add(new int[]{w, v});
    //         }
    //     }
        
    //     return sum;
    }
}
