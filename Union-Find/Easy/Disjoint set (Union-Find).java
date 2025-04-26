/*Complete the function below*/
class GfG {
    int find(int par[], int x) {
        // add code here.
        
        // Time Complexity : O(n)
        
        while(par[x] != x){
            x = par[x];
        }
        
        return x;
    }

    void unionSet(int par[], int x, int z) {
        // add code here.
        
        int ult_x = find(par, x);
        int ult_z = find(par, z);
        
        par[ult_x] = par[ult_z];
        return;
    }
}
