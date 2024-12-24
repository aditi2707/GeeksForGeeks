class Solution {
    
    private void pascalTriangle(List<Integer> prev, List<Integer> curr, int i, int r){
        
        if(i == 0){
            curr.add(1);
            pascalTriangle(prev, curr, i + 1, r);
            return;
        }
        if(i == prev.size()){
            curr.add(1);
            return;
        }
        if(i > r){
            return;
        }
        
        curr.add(prev.get(i) + prev.get(i - 1));
        pascalTriangle(prev, curr, i + 1, r);
        
        return;
    }
    
    public int nCr(int n, int r) {
        // code here
        
        if(r > n){
            return 0;
        }
        
        List<Integer>prev = new ArrayList<>();
        prev.add(1);
        
        
        for(int i = 1; i <= n; i++){
            List<Integer> curr = new ArrayList<>();
            pascalTriangle(prev, curr, 0, r);
            
            prev = curr;
        }
        
        return prev.get(r);
    }
}
