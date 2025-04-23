class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        
        // Time Complexity : O(V + V + E + V + E)
        // Filling the distance[] will take linear time. The second for loop will
        // add a new list at every vertex, so TC = O(V). The third for loop will
        // run for all the edges so, TC = O(E). The last while loop will run for
        // every vertex in the worst case, and the for loop inside that will run
        // for each edge for that vertex. So the total TC = O(V + E).
        
        // Space Complexity : O(V + E + V + V)
        // The adj list will have all vertices and their edges, so SC = O(V + E).
        // The queue can have all the vertices in worst case, so SC = O(V).
        // The distance[] will contain all vertices, so SC = O(V).
        
        
        List<List<int[]>> adjList = new ArrayList<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0]? a[1] - b[1] : a[0] - b[0];
        });
        int[] distance = new int[V];
        
        Arrays.fill(distance, Integer.MAX_VALUE);
        
        for(int i = 0; i < V; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            int edge = i[2];
            
            adjList.get(u).add(new int[]{v, edge});
            adjList.get(v).add(new int[]{u, edge});
        }
        
        minHeap.add(new int[]{0, src});
        distance[src] = 0;
        
        while(minHeap.size() > 0){
            int[] poll = minHeap.poll();
            int d = poll[0];
            int n = poll[1];
            
            for(int[] i: adjList.get(n)){
                int node = i[0];
                int origDist = i[1];
                if(distance[node] > d + origDist){
                    distance[node] = Math.min(distance[node], d + origDist);
                    minHeap.add(new int[]{distance[node], node});
                }
                
            }
        }
        
        return distance;
        
    }
}
