class Solution {
    
    int count(int n, int[] dp){
        
        if(n == 1){
            return 2;
        }
        if(n == 2){
            return 3;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = count(n - 1, dp) + count(n - 2, dp);
        return dp[n];
    }
    
    int countStrings(int n) {
        // code here
        
        if(n == 1){
            return 2;
        }
        if(n == 2){
            return 3;
        }
        
        int prev2 = 2;
        int prev = 3;
        
        for(int i = 3; i <= n; i++){
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        
        return prev;
        
        
        
        
        
        
        
        // if(n == 1){
        //     return 2;
        // }
        // if(n == 2){
        //     return 3;
        // }
        
        // int[] dp = new int[n + 1];
        
        // dp[1] = 2;
        // dp[2] = 3;
        
        // for(int i = 3; i <= n; i++){
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        
        // return dp[n];
        
        
        
        
        
        
        // int[] dp = new int[n + 1];
        
        // Arrays.fill(dp, -1);
        
        // return count(n, dp);
    }
}
