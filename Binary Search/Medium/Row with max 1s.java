// User function Template for Java

class Solution {
    
    private int firstOccurence(int[] nums){
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(nums[mid] == 1){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    
    public int rowWithMax1s(int arr[][]) {
        // code here
        
        // Time Complexity : O(nlog n)
        
        // Space Complexity : O(1)
        
        
        int row = -1, max = 0;
        
        for(int i = 0; i < arr.length; i++){
            int first = firstOccurence(arr[i]);
            
            if((arr[i].length - first) > max){
                max = (arr[i].length - first);
                row = i;
            }
        }
        
        return row;
    }
}
