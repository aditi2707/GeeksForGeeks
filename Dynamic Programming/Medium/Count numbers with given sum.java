class Solution {
    
    private static int countNumbers(int n, int sum, int[][] dp){
        
        if(n == 0){
            if(sum == 0){
                return 1;
            }
            return 0;
        }
        
        if(dp[n][sum] != -1){
            return dp[n][sum];
        }
        
        int pick = 0;
        for(int i = 0; i <= 9; i++){
            if(n == 1 && i == 0){
                continue;
            }
            if(sum - i >= 0){
                pick = (pick + countNumbers(n - 1, sum - i, dp)) % 1000000007;
            }
        }
        
        return dp[n][sum] = pick;
    }
    
    
    static long countWays(int n, int sum) {
        // code here
        
        int[] prev = new int[sum + 1];
        
        prev[0] = 1;
        
        for(int i = 1; i <= n; i++){
            int[] curr = new int[sum + 1];
            for(int j = 1; j <= sum; j++){
                int pick = 0;
                for(int k = 0; k <= 9; k++){
                    if(i == 1 && k == 0){
                        continue;
                    }
                    if(j - k >= 0){
                        pick = (pick + prev[j - k]) % 1000000007;
                    }
                }
        
                curr[j] = pick;
            }
            prev = curr;
        }
        
        return prev[sum] == 0? -1 : prev[sum];
        
        
        
        
        // int[][] dp = new int[n + 1][sum + 1];
        
        // dp[0][0] = 1;
        
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= sum; j++){
        //         int pick = 0;
        //         for(int k = 0; k <= 9; k++){
        //             if(i == 1 && k == 0){
        //                 continue;
        //             }
        //             if(j - k >= 0){
        //                 pick = (pick + dp[i - 1][j - k]) % 1000000007;
        //             }
        //         }
        
        //         dp[i][j] = pick;
        //     }
        // }
        
        // return dp[n][sum] == 0? -1 : dp[n][sum];
        
        
        
        
        
        // int[][] dp = new int[n + 1][sum + 1];
        
        // for(int i = 0; i <= n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // int ans = countNumbers(n, sum, dp);
        // return ans == 0? -1 : ans;
    }
}
