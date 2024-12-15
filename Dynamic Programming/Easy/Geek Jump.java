class Solution{
    
    public int geekJump(int[] arr, int i, int[] dp){
        if(i <= 0){
            return 0;
        }
        if(i == 1){
            return Math.abs(arr[0] - arr[1]);
        }
        
        if(dp[i] != -1){
            return dp[i];
        }
        
        int one = Math.abs(arr[i] - arr[i - 1]) + geekJump(arr, i - 1, dp);
        int two = Math.abs(arr[i] - arr[i - 2]) + geekJump(arr, i - 2, dp);
        
        dp[i] = Math.min(one, two);
        return dp[i];
    }
    
    public int minimumEnergy(int arr[],int N){
        
        if(N == 1){
            return 0;
        }
        if(N == 2){
            return Math.abs(arr[0] - arr[1]);
        }
        
        
        int prev2 = 0;
        int prev = Math.abs(arr[0] - arr[1]);
        
        for(int i = 2; i < N; i++){
            int one = Math.abs(arr[i] - arr[i - 1]) + prev;
            int two = Math.abs(arr[i] - arr[i - 2]) + prev2;
        
            int curr = Math.min(one, two);
            
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
        
        
        
        
        
        
        
        
        
        // if(N == 1){
        //     return 0;
        // }
        // if(N == 2){
        //     return Math.abs(arr[0] - arr[1]);
        // }
        
        // int[] dp = new int[arr.length];
        
        // dp[0] = 0;
        // dp[1] = Math.abs(arr[0] - arr[1]);
        
        // for(int i = 2; i < N; i++){
        //     int one = Math.abs(arr[i] - arr[i - 1]) + dp[i - 1];
        //     int two = Math.abs(arr[i] - arr[i - 2]) + dp[i - 2];
        
        //     dp[i] = Math.min(one, two); 
        // }
        
        // return dp[dp.length - 1];
        
        
        
        
        
        
        
        
        // int[] dp = new int[arr.length];
        
        // Arrays.fill(dp, -1);
        // return geekJump(arr, arr.length - 1, dp);
    }
}
