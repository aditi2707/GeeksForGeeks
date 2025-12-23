class Solution {
    
    private int allocatePages(int[] arr, int minPages){
        
        int sum = 0, k = 0;
        
        for(Integer i: arr){
            sum += i;
            
            if(sum > minPages){
                k++;
                sum = i;
            }
        }
        
        k++;
        
        return k;
    }
    
    public int findPages(int[] arr, int k) {
        // code here
        
        // Time Complexity : O(nlog (sum - max))
        
        // Space Complexity : O(1)
        
        
        if(k > arr.length){
            return -1;
        }
        
        int ans = 0;
        
        int max = arr[0], sum = 0;
        
        for(Integer i: arr){
            max = Math.max(max, i);
            sum += i;
        }
        
        int low = max, high = sum;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            int students = allocatePages(arr, mid);
            
            if(students > k){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        
        return ans;
    }
}
