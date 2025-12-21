class Solution {
    public int nthRoot(int n, int m) {
        // code here
        
        // Time Complexity : O(log (m / n))
        
        // Space Complexity : O(1)
        
        
        if(m == 0 || m == 1){
            return m;
        }
        
        int low = 1, high = m / n;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if((long)Math.pow(mid, n) == (long)m){
                return mid;
            }
            else if((long)Math.pow(mid, n) < (long)m){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return -1;
    }
}
