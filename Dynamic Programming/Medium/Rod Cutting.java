class Solution {
    
    private int rodCutting(int[] price, int i, int target, int[][] dp){
        
        if(target == 0){
            return 0;
        }
        if(i < 0 || target < 0){
            return 0;
        }
        
        if(dp[i + 1][target] != -1){
            return dp[i + 1][target];
        }
        
        int pick = 0;
        
        if(target - (i + 1) >= 0){
            pick = Math.max(price[i] + rodCutting(price, i, target - (i + 1), dp), 
            rodCutting(price, i - 1, target, dp));
        }
        else{
            pick = rodCutting(price, i - 1, target, dp);
        }
        
        return dp[i + 1][target] = pick;
    }
    
    
    public int cutRod(int[] price) {
        // code here
        
        int[] prev = new int[price.length + 1];
        
        for(int i = 1; i <= price.length; i++){
            int[] curr = new int[price.length + 1];
            for(int j = 1; j <= price.length; j++){
                int pick = 0;
        
                if(j - i >= 0){
                    pick = Math.max(price[i - 1] + curr[j - i], prev[j]);
                }
                else{
                    pick = prev[j];
                }
        
                curr[j] = pick;
            }
            prev = curr;
        }
        
        return prev[price.length];
        
        
        
        
        // int[][] dp = new int[price.length + 1][price.length + 1];
        
        // for(int i = 1; i <= price.length; i++){
        //     for(int j = 1; j <= price.length; j++){
        //         int pick = 0;
        
        //         if(j - i >= 0){
        //             pick = Math.max(price[i - 1] + dp[i][j - i], dp[i - 1][j]);
        //         }
        //         else{
        //             pick = dp[i - 1][j];
        //         }
        
        //         dp[i][j] = pick;
        //     }
        // }
        
        // return dp[price.length][price.length];
        
        
        
        
        // int[][] dp = new int[price.length + 1][price.length + 1];
        
        // for(int i = 0; i <= price.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return rodCutting(price, price.length - 1, price.length, dp);
    }
}
