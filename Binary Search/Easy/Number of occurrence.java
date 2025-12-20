class Solution {
    int countFreq(int[] arr, int target) {
        // code here
        
        // Time Complexity : O((log n) * 2)
        
        // Space Complexity : O(1)
        
        
        int start = 0, end = 0;
        
        int low = 0, high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        if((low < arr.length && arr[low] != target)){
            return 0;
        }
        if(low < 0){
            return high;
        }
        start = low;
        
        
        low = 0; high = arr.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        if(high >= 0 && arr[high] != target){
            return 0;
        }
        if(high == arr.length){
            return arr.length - low;
        }
        
        end = high;
        
        return end - start + 1;
    }
}
