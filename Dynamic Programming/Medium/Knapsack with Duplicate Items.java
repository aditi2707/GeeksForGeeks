class Solution {
    
    private static int unboundedKnapsack(int[] val, int[] wt, int i, 
    int capacity, int[][] dp){
        
        if(i < 0 || capacity < 0){
            return 0;
        }
        
        if(dp[i][capacity] != -1){
            return dp[i][capacity];
        }
        
        int pick = 0;
        if(capacity - wt[i] >= 0){
            pick = Math.max(val[i] + unboundedKnapsack(val, wt, i, capacity - wt[i], dp), 
            unboundedKnapsack(val, wt, i - 1, capacity, dp));
        }
        else{
            pick = unboundedKnapsack(val, wt, i - 1, capacity, dp);
        }
        
        return dp[i][capacity] = pick;
    }
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        
        int[] prev = new int[capacity + 1];
        
        for(int i = 0; i <= capacity; i++){
            prev[i] = (i / wt[0]) * val[0];
        }
        
        for(int i = 1; i < wt.length; i++){
            int[] curr = new int[capacity + 1];
            for(int j = 0; j <= capacity; j++){
                int pick = 0;
                if(j - wt[i] >= 0){
                    pick = Math.max(val[i] + curr[j - wt[i]], prev[j]);
                }
                else{
                    pick = prev[j];
                }
        
                curr[j] = pick;
            }
            prev = curr;
        }
        
        return prev[capacity];
        
        
        
        
        
        
        // int[][] dp = new int[wt.length][capacity + 1];
        
        // for(int i = 0; i <= capacity; i++){
        //     dp[0][i] = (i / wt[0]) * val[0];
        // }
        
        // for(int i = 1; i < wt.length; i++){
        //     for(int j = 0; j <= capacity; j++){
        //         int pick = 0;
        //         if(j - wt[i] >= 0){
        //             pick = Math.max(val[i] + dp[i][j - wt[i]], dp[i - 1][j]);
        //         }
        //         else{
        //             pick = dp[i - 1][j];
        //         }
        
        //         dp[i][j] = pick;
        //     }
        // }
        
        // return dp[wt.length - 1][capacity];
        
        
        
        
        // int[][] dp = new int[wt.length][capacity + 1];
        
        // for(int i = 0; i < wt.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return unboundedKnapsack(val, wt, wt.length - 1, capacity, dp);
    }
}
