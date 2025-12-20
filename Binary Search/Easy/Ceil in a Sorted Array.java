// User function Template for Java
class Solution {
    public int findCeil(int[] arr, int x) {
        // code here
        
        // Time Complexity : O(log n)
        
        // Space Complexity : O(1)
        
        
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        if(low >= arr.length){
            return -1;
        }
        
        return low;
    }
}
