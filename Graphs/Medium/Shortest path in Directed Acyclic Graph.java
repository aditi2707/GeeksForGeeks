class Solution {
    
    static class Pair {
        int node;
        int weight;
        Pair(int n, int wt){
            this.node = n;
            this.weight = wt;
        }
    }
    
    private void topoDfs(List<List<Pair>> list, int[] visited, Stack<Integer> stack, int src){
        
        visited[src] = 1;
        
        for(Pair p: list.get(src)){
            if(visited[p.node] == 0){
                topoDfs(list, visited, stack, p.node);
            }
        }
        
        stack.push(src);
        return;
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        
        List<List<Pair>> list = new ArrayList<>();
        int[] visited = new int[V];
        int[] distance = new int[V];
        
        for(int i = 0; i < V; i++){
            list.add(new ArrayList<Pair>());
        }
        for(int i = 0; i < E; i++){
            
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            
            list.get(u).add(new Pair(v, wt));
        }
        
        Arrays.fill(distance, 1000000000);
        distance[0] = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < V; i++){
            if(visited[i] == 0){
                topoDfs(list, visited, stack, i);
            }
        }
        
        while(!stack.isEmpty()){
            int pop = stack.pop();
            int dist = distance[pop];
            
            for(Pair p: list.get(pop)){
                // if(dist == Integer.MAX_VALUE){
                //     dist = 0;
                // }
                distance[p.node] = Math.min(distance[p.node], dist + p.weight);
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
