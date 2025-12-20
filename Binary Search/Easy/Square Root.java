class Solution {
    int floorSqrt(int n) {
        // code here
        
        // Time Complexity : O(log n)
        
        // Space Complexity : O(1)
        
        
        if(n == 1){
            return 1;
        }
        
        int high = n / 2;
        int low = 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if((mid * mid) == n){
                return mid;
            }
            else if((mid * mid) < n){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        
        if(low > high){
            return high;
        }
        
        return low;
    }
}
