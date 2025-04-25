class Solution {
    int findCity(int n, int m, int[][] edges,int distanceThreshold){
        //code here
        
        // ** Dijkstra's Algorithm **
        
        // Time Complexity : O(V + E + V * (V + Elog V + V))
        
        // Space Complexity : O((V + 2 * E) + V + E)
        
        
        List<List<int[]>> adjList = new ArrayList<>();
        int[] distance = new int[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> {
            return a[0] == b[0]? a[1] - b[1] : a[0] - b[0];
        });
            
        int minCount = n;
        int maxVertex = 0;
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] i: edges){
            int u = i[0];
            int v = i[1];
            int wt = i[2];
            
            adjList.get(u).add(new int[]{v, wt});
            adjList.get(v).add(new int[]{u, wt});
        }
        
        for(int vertex = 0; vertex < n; vertex++){
            
            Arrays.fill(distance, 1000000000);
            
            distance[vertex] = 0;
            minHeap.add(new int[]{0, vertex});
            
            while(!minHeap.isEmpty()){
                int[] poll = minHeap.poll();
                int dist = poll[0];
                int u = poll[1];
                
                for(int[] i: adjList.get(u)){
                    int v = i[0];
                    int wt = i[1];
                    
                    if(dist + wt < distance[v]){
                        distance[v] = dist + wt;
                        minHeap.add(new int[]{distance[v], v});
                    }
                }
            }
            
            int count = 0;
            for(Integer i: distance){
                if(i <= distanceThreshold){
                    count++;
                }
            }
                
            if(count < minCount){
                minCount =count;
                maxVertex = vertex;
            }
            else if(count == minCount){
                maxVertex = vertex;
            }
        }
        
        return maxVertex;
        
        
        
        
        
        
        // // ** Floyd Warshall Algorithm **
        
        // // Time Complexity : O((V ^ 2) + E + (V ^ 3) + (V ^ 2))
        
        // // Space Complexity : O(V ^ 2)
        
        
        // int[][] shortestDistance = new int[n][n];
        
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j < n; j++){
        //         if(i == j){
        //             shortestDistance[i][i] = 0;
        //         }
        //         else{
        //             shortestDistance[i][j] = 1000000000;
        //         }
        //     }
        // }
        
        // for(int[] i: edges){
        //     int u = i[0];
        //     int v = i[1];
        //     int wt = i[2];
            
        //     shortestDistance[u][v] = wt;
        //     shortestDistance[v][u] = wt;
        // }
        
        // for(int k = 0; k < n; k++){
        //     for(int i = 0; i < n; i++){
        //         for(int j = 0; j < n; j++){
        //             if(shortestDistance[i][k] != 1000000000 && 
        //             shortestDistance[k][j] != 1000000000){
        //                 shortestDistance[i][j] = Math.min(shortestDistance[i][j], 
        //                 shortestDistance[i][k] + shortestDistance[k][j]);
        //             }
        //         }
        //     }
        // }
        
        // int minCount = n;
        // int maxVertex = 0;
        
        // for(int i = 0; i < n; i++){
        //     int count = 0;
        //     for(int j = 0; j < n; j++){
        //         if(shortestDistance[i][j] <= distanceThreshold){
        //             count++;
        //         }
        //     }
        //     if(count < minCount){
        //         minCount = count;
        //         maxVertex = i;
        //     }
        //     else if(count == minCount){
        //         maxVertex = Math.max(maxVertex, i);
        //     }
        // }
        
        // return maxVertex;
    }
}
