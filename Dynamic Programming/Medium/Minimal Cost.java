class Solution {
    
    public int minimalCost(int[] arr, int i, int k, int[] dp){
        
        if(i <= 0){
            return 0;
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int min = 10001;
        for(int j = i - 1; j > i - 1 - k; j--){
            if(j >= 0){
                min = Math.min(min, Math.abs(arr[i] - arr[j]) + minimalCost(arr, j, k, dp));
            }
            else{
                break;
            }
        }
        
        dp[i] = min;
        return dp[i];
    }
    
    public int minimizeCost(int k, int arr[]) {
        
        int[] dp = new int[arr.length];
        dp[0] = 0;
        
        for(int i = 1; i < arr.length; i++){
            int min = 10001;
            for(int j = i - 1; j > i - 1 - k; j--){
                if(j >= 0){
                    min = Math.min(min, Math.abs(arr[i] - arr[j]) + dp[j]);
                }
                else{
                    break;
                }
            }
            dp[i] = min;
        }
        
        return dp[dp.length - 1];
        
        
        
        
        
        
        
        // int[] dp = new int[arr.length];
        // Arrays.fill(dp, -1);
        
        // return minimalCost(arr, arr.length - 1, k, dp);
    }
}
