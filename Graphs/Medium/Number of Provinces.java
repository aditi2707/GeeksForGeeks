class Solution {

    private static int find(int[] par, int a){
        
        if(par[a] == a){
            return a;
        }
        
        return par[a] = find(par, par[a]);
    }
    
    private static void dfs(ArrayList<ArrayList<Integer>> adj, int source, int[] visited){
        
        visited[source] = 1;
        
        for(int i = 0; i < adj.get(source).size(); i++){
            if(visited[i] == 0 && adj.get(source).get(i) == 1){
                dfs(adj, i, visited);
            }
        }
        
        return;
    }

    
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here

        int[] parent = new int[V];
        int[] rank = new int[V];
        int ans = 0;
        
        for(int i = 0; i < V; i++){
            parent[i] = i;
        }
        
        for(int i = 0; i < adj.size(); i++){
            for(int j = 0; j < adj.get(i).size(); j++){
                if(adj.get(i).get(j) == 1){
                    int u = i;
                    int v = j;
                    
                    int ult_u = find(parent, u);
                    int ult_v = find(parent, v);
                    
                    if(ult_u != ult_v){
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
            }
        }
        
        for(int i = 0; i < parent.length; i++){
            if(parent[i] == i){
                ans++;
            }
        }
        
        return ans;


        
        
        // int[] visited = new int[V];
        // int ans = 0;
        
        // for(int i = 0; i < V; i++){
        //     if(visited[i] == 0){
        //         ans++;
        //         dfs(adj, i, visited);
        //     }
        // }
        
        // return ans;
    }
};
