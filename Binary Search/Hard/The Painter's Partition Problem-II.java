class Solution {
    
    private int painterPartition(int[] arr, int minLength){
        
        int sum = 0, k = 0;
        
        for(Integer i: arr){
            sum += i;
            
            if(sum > minLength){
                k++;
                sum = i;
            }
        }
        
        k++;
        
        return k;
    }
    
    
    public int minTime(int[] arr, int k) {
        // code here
        
        // Time Complexity : O(n + nlog (sum - max))
        
        // Space Complexity : O(1)
        
        
        if(arr.length < k){
            return -1;
        }
        
        int max = arr[0], sum = 0;
        
        for(Integer i: arr){
            max = Math.max(max, i);
            sum += i;
        }
        
        int low = max, high = sum, ans = 0;
        
        while(low <= high){
            
            int mid = (low + high) / 2;
            
            int painters = painterPartition(arr, mid);
            
            if(painters > k){
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
