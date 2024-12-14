// User function Template for Java

class Solution {
    
    public static int hops(int n, int[] dp){
        
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        
        if(dp[n] != -1){
            return dp[n];
        }
        
        dp[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return dp[n];
    }
    
    // Function to count the number of ways in which frog can reach the top.
    static int countWays(int n) {
        
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        if(n == 3){
            return 4;
        }
        
        
        int prev3 = 1;
        int prev2 = 2;
        int prev1 = 4;
        
        for(int i = 4; i <= n; i++){
            int curr = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        
        return prev1;
        
        
        
        
        
        
        
        
        // if(n == 1){
        //     return 1;
        // }
        // if(n == 2){
        //     return 2;
        // }
        // if(n == 3){
        //     return 4;
        // }
        
        // int[] dp = new int[n + 1];
        
        // dp[0] = 0;
        // dp[1] = 1;
        // dp[2] = 2;
        // dp[3] = 4;
        
        // for(int i = 4; i <= n; i++){
        //     dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        // }
        
        // return dp[n];
        
        
        
        
        
        
        
        
        
        
        // int[] dp = new int[n + 1];
        // Arrays.fill(dp, -1);
        
        // return hops(n, dp);
    }    
}
