class Solution
{
    private static int reachOrigin(int i, int j, int[][] dp){
        
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int left = reachOrigin(i, j - 1, dp);
        int up = reachOrigin(i - 1, j, dp);
        
        dp[i][j] = (left + up) % 1000000007;
        
        return dp[i][j];
    }
    
    public static int ways(int n, int m)
    {
        
        int[] prev = new int[m + 1];
        
        for(int i = 0; i <= m; i++){
            prev[i] = 1;
        }
        
        for(int i = 1; i <= n; i++){
            int[] curr = new int[m + 1];
            curr[0] = 1;
            for(int j = 1; j <= m; j++){
                curr[j] = (curr[j - 1] + prev[j]) % 1000000007; 
            }
            
            prev = curr;
        }
        
        return prev[m];
        
        
        
        
        
        
        
        
        // int[][] dp = new int[n + 1][m + 1];
        
        // dp[0][0] = 1;
        
        // for(int i = 1; i <= m; i++){
        //     dp[0][i] = 1;
        // }
        // for(int i = 1; i <= n; i++){
        //     dp[i][0] = 1;
        // }
        
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        
        //         dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1000000007; 
        //     }
        // }
        
        // return dp[n][m];
        
        
        
        
        
        
        
        // int[][] dp = new int[n + 1][m + 1];
        
        // for(int i = 0; i <= n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // return reachOrigin(n, m, dp);
    }
}
