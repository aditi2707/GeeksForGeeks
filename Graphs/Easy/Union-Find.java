class Solution {
    
    private int find(int[] par, int a){
        
        // Time Complexity : O(n)
        
        while(par[a] != a){
            a = par[a];
        }
        
        return par[a] = a;
    }
    
    
    // Function to merge two nodes a and b.
    public void union_(int a, int b, int par[], int rank[]) {
        // add your code here
        
        // Time Complexity : O(n + n)
        
        
        int ult_a = find(par, a);
        int ult_b = find(par, b);
        
        if(rank[ult_a] == rank[ult_b]){
            par[ult_b] = ult_a;
            rank[ult_a] += 1;
        }
        else if(rank[ult_a] > rank[ult_b]){
            par[ult_b] = ult_a;
           
        }
        else{
            par[ult_a] = ult_b;
        }
        
        return;
    }

    // Function to check whether 2 nodes are connected or not.
    public Boolean isConnected(int a, int b, int par[], int rank[]) {
        // add your code here
        
        // Time Complexity : O(1)
        
        
        int ult_a = find(par, a);
        int ult_b = find(par, b);
        
        return ult_a == ult_b;
    }
}
