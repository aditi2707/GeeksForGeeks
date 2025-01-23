class Solution {
    
    private static int knapsackProblem(int[] val, int[] wt, int m, int capacity, int[][] dp){
        
        if(m < 0){
            return 0;
        }
        
        if(dp[m][capacity] != -1){
            return dp[m][capacity];
        }
        
        int pick = 0;
        if(capacity - wt[m] >= 0){
            pick = Math.max(val[m] + knapsackProblem(val, wt, m - 1, capacity - wt[m], dp), 
            knapsackProblem(val, wt, m - 1, capacity, dp));
        }
        else{
            pick = knapsackProblem(val, wt, m - 1, capacity, dp);
        }
        
        return dp[m][capacity] = pick;
    }
    
    
    // Function to return max value that can be put in knapsack of capacity.
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        
        int[] prev = new int[capacity + 1];
        
        for(int i = 1; i <= capacity; i++){
            if(wt[0] <= i){
                prev[i] = val[0];
            }
        }
        
        for(int i = 1; i < wt.length; i++){
            int[] curr = new int[capacity + 1];
            for(int j = 1; j <= capacity; j++){
                int pick = 0;
                if(j - wt[i] >= 0){
                    pick = Math.max(val[i] + prev[j - wt[i]], 
                    prev[j]);
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
        
        // for(int i = 1; i <= capacity; i++){
        //     if(wt[0] <= i){
        //         dp[0][i] = val[0];
        //     }
        // }
        
        // for(int i = 1; i < wt.length; i++){
        //     for(int j = 1; j <= capacity; j++){
        //         int pick = 0;
        //         if(j - wt[i] >= 0){
        //             pick = Math.max(val[i] + dp[i - 1][j - wt[i]], 
        //             dp[i - 1][j]);
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
        //     for(int j = 0; j <= capacity; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        
        // return knapsackProblem(val, wt, wt.length - 1, capacity, dp);
    }
}
