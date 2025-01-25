class Solution {
    
    private static int minCost(int[] cost, int w, int i, int[][] dp){
        
        if(w == 0){
            return 0;
        }
        if(i < 0 || w < 0){
            return Integer.MAX_VALUE / 2;
        }
        
        if(dp[i + 1][w] != -1){
            return dp[i + 1][w];
        }
        
        int pick = 0;
        
        if(w - (i + 1) >= 0 && cost[i] != -1){
            pick = Math.min(cost[i] + minCost(cost, w - (i + 1), i, dp), 
            minCost(cost, w, i - 1, dp));
        }
        else{
            pick = minCost(cost, w, i - 1, dp);
        }
        
        return dp[i + 1][w] = pick;
    }
    
    
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        
        int[] prev = new int[w + 1];
        
        for(int i = 0; i <= w; i++){
            prev[i] = Integer.MAX_VALUE / 2;
        }
        
        for(int i = 1; i <= cost.length; i++){
            int[] curr = new int[w + 1];
            for(int j = 1; j <= w; j++){
                int pick = 0;
        
                if(j - i >= 0 && cost[i - 1] != -1){
                    pick = Math.min(cost[i - 1] + curr[j - i], prev[j]);
                }
                else{
                    pick = prev[j];
                }
        
                curr[j] = pick;
            }
            prev = curr;
        }
        
        return prev[w] >= Integer.MAX_VALUE / 2? -1 : prev[w];
        
        
        
        
        
        
        // int[][] dp = new int[cost.length + 1][w + 1];
        
        // for(int i = 0; i <= w; i++){
        //     dp[0][i] = Integer.MAX_VALUE / 2;
        // }
        
        // for(int i = 1; i <= cost.length; i++){
        //     for(int j = 1; j <= w; j++){
        //         int pick = 0;
        
        //         if(j - i >= 0 && cost[i - 1] != -1){
        //             pick = Math.min(cost[i - 1] + dp[i][j - i], dp[i - 1][j]);
        //         }
        //         else{
        //             pick = dp[i - 1][j];
        //         }
        
        //         dp[i][j] = pick;
        //     }
        // }
        
        // return dp[cost.length][w] >= Integer.MAX_VALUE / 2? -1 : dp[cost.length][w];
        
        
        
        
        
        // int[][] dp = new int[cost.length + 1][w + 1];
        
        // for(int i = 0; i <= cost.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // int ans = minCost(cost, w, n - 1, dp);
        
        // return ans >= Integer.MAX_VALUE / 2? -1 : ans;
    }
}
