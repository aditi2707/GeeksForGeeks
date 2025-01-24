class Solution {
    
    private int coinChange(int[] coins, int i, int sum, int[][] dp){
        
        if(sum == 0){
            return 0;
        }
        if(i < 0 || sum < 0){
            return Integer.MAX_VALUE - 1;
        }
        
        if(dp[i][sum] != -1){
            return dp[i][sum];
        }
        
        int pick = Integer.MAX_VALUE - 1, notPick = Integer.MAX_VALUE - 1;
        
        if(coins[i] > 0 && sum - coins[i] >= 0){
            pick = Math.min(1 + coinChange(coins, i, sum - coins[i], dp), 
            coinChange(coins, i - 1, sum, dp));
        }
        else{
            notPick = coinChange(coins, i - 1, sum, dp);
        }
        
        return dp[i][sum] = Math.min(pick, notPick);
    }


    public int minCoins(int coins[], int sum) {
        // Your code goes here
        
        int[] prev = new int[sum + 1];
        
        for(int i = 1; i <= sum; i++){
            prev[i] = Integer.MAX_VALUE - 1;
        }
        
        for(int i = 1; i <= coins.length; i++){
            int[] curr = new int[sum + 1];
            for(int j = 1; j <= sum; j++){
                int pick = Integer.MAX_VALUE - 1, notPick = Integer.MAX_VALUE - 1;
        
                if(coins[i - 1] > 0 && j - coins[i - 1] >= 0){
                    pick = Math.min(1 + curr[j - coins[i - 1]], prev[j]);
                }
                else{
                    notPick = prev[j];
                }
        
                curr[j] = Math.min(pick, notPick);
            }
            prev = curr;
        }
        
        
        return prev[sum] >= Integer.MAX_VALUE - 1? -1 : prev[sum];
        
        
        
        
        
        
        // int[][] dp = new int[coins.length + 1][sum + 1];
        
        // for(int i = 0; i < coins.length; i++){
        //     dp[i][0] = 0;
        // }
        // for(int i = 1; i <= sum; i++){
        //     dp[0][i] = Integer.MAX_VALUE - 1;
        // }
        
        // for(int i = 1; i <= coins.length; i++){
        //     for(int j = 1; j <= sum; j++){
        //         int pick = Integer.MAX_VALUE - 1, notPick = Integer.MAX_VALUE - 1;
        
        //         if(coins[i - 1] > 0 && j - coins[i - 1] >= 0){
        //             pick = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
        //         }
        //         else{
        //             notPick = dp[i - 1][j];
        //         }
        
        //         dp[i][j] = Math.min(pick, notPick);
        //     }
        // }
        
        
        // return dp[coins.length][sum] >= Integer.MAX_VALUE - 1? -1 : dp[coins.length][sum];
        
        
        
        
        
        
        // int[][] dp = new int[coins.length][sum + 1];
        
        // for(int i = 0; i < coins.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // int ans = coinChange(coins, coins.length - 1, sum, dp);
        // return ans >= Integer.MAX_VALUE - 1? -1 : ans;
    }
}
