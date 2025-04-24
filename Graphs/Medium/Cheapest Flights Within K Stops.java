class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        
        // Time Complexity : O(V + V + E + E)
        // Filling the cheapestPrice[] and adjList will take O(V) time. The 
        // flights[] will have info of every edge so that will take O(E) time.
        // The last while loop is running for every edge only as the graph is 
        // directed and we are using a simple queue. So, TC = O(E).
        
        // Space Complexity : O(v + E + V + V)
        // THe adjList will have info of every edge and vertex. Queue and 
        // cheapestPrice[] will contain a max of vertices size hence TC = O(V).
        
        
        List<List<int[]>> adjList = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        int[] cheapestPrice = new int[n];
        
        Arrays.fill(cheapestPrice, Integer.MAX_VALUE);
        
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }
        
        for(int[] i: flights){
            int u = i[0];
            int v = i[1];
            int price = i[2];
            
            adjList.get(u).add(new int[]{v, price});
        }
        
        queue.add(new int[]{0, src, 0});
        cheapestPrice[src] = 0;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int stops = poll[0];
            int s = poll[1];
            int dist = poll[2];
            
            if(stops > k){
                continue;
            }
            
            for(int[] i: adjList.get(s)){
                int d = i[0];
                int p = i[1];
                
                if(dist + p < cheapestPrice[d]){
                    cheapestPrice[d] = dist + p;
                    queue.add(new int[]{stops + 1, d, cheapestPrice[d]});
                }
            }
        }
        
        return cheapestPrice[dst] == Integer.MAX_VALUE? -1 : cheapestPrice[dst];
    }
}
