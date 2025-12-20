class Solution {
    int upperBound(int[] arr, int target) {
        // code here
        
        // Time Complexity : O(log n)
        
        // Space Complexity : O(1)
        
        
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return low;
    }
}
