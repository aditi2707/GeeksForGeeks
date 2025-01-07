class Solution {
    // Function to find the shortest path from a source node to all other nodes
    public int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int src) {
        // code here
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});
        
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, 1000000000);
        
        distance[src] = 0;
        
        while(!queue.isEmpty()){
            int[] poll = queue.poll();
            int node = poll[0];
            int wt = poll[1];
            
            for(Integer i: adj.get(node)){
                if(wt + 1 < distance[i]){
                    distance[i] = wt + 1;
                    queue.add(new int[]{i, distance[i]});
                }
            }
        }
        
        for(int i = 0; i < distance.length; i++){
            if(distance[i] >= 1000000000){
                distance[i] = -1;
            }
        }
        
        return distance;
    }
}
