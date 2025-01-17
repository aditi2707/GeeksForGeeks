class Solution {
    
    private int goldMine(int[][] mat, int i, int j, int[][] dp){
        
        if(i >= mat.length || i < 0){
            return 0;
        }
        if(j >= mat[0].length || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        
        int diagUp = mat[i][j] + goldMine(mat, i - 1, j + 1, dp);
        int right = mat[i][j] + goldMine(mat, i, j + 1, dp);
        int diagDown = mat[i][j] + goldMine(mat, i + 1, j + 1, dp);
        
        dp[i][j] = Math.max(diagUp, Math.max(right, diagDown));
        return dp[i][j];
    }
    
    
    public int maxGold(int mat[][]) {
        
        int max = 0;
        int[] prev = new int[mat.length];
        
        for(int i = 0; i < mat.length; i++){
            prev[i] = mat[i][0];
        }
        
        for(int j = 1; j < mat[0].length; j++){
            int[] curr = new int[mat.length];
            for(int i = 0; i < mat.length; i++){
                
                int diagUp = 0;
                int left = 0;
                int diagDown = 0;
                
                if(i - 1 >= 0 && j - 1 >= 0){
                    diagUp = mat[i][j] + prev[i - 1];
                }
                if(j - 1 >= 0){
                    left = mat[i][j] + prev[i];
                }
                if(i + 1 < mat.length && j - 1 >= 0){
                    diagDown = mat[i][j] + prev[i + 1];
                }
                
                curr[i] = Math.max(diagUp, Math.max(left, diagDown));
                max = Math.max(max, curr[i]);
            }
            prev = curr;
        }
        
        return max;
        
        
        
        
        
        
        // code here
        
        // int max = 0;
        // int[][] dp = new int[mat.length][mat[0].length];
        
        // for(int i = 0; i < mat.length; i++){
        //     dp[i][0] = mat[i][0];
        // }
        
        // for(int j = 1; j < mat[0].length; j++){
        //     for(int i = 0; i < mat.length; i++){
                
        //         int diagUp = 0;
        //         int left = 0;
        //         int diagDown = 0;
                
        //         if(i - 1 >= 0 && j - 1 >= 0){
        //             diagUp = mat[i][j] + dp[i - 1][j - 1];
        //         }
        //         if(j - 1 >= 0){
        //             left = mat[i][j] + dp[i][j - 1];
        //         }
        //         if(i + 1 < mat.length && j - 1 >= 0){
        //             diagDown = mat[i][j] + dp[i + 1][j - 1];
        //         }
                
        //         dp[i][j] = Math.max(diagUp, Math.max(left, diagDown));
        //         max = Math.max(max, dp[i][mat[0].length - 1]);
        //     }
        // }
        
        // // for(int i = 0; i < mat.length; i++){
        // //     max = Math.max(max, dp[i][mat[0].length - 1]);
        // // }
        
        // return max;
        
        
    
        
        
        
        // int max = 0;
        // int[][] dp = new int[mat.length][mat[0].length];
        
        // for(int i = 0; i < mat.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // for(int i = 0; i < mat.length; i++){
        //     max = Math.max(max, goldMine(mat, i, 0, dp));
        // }
        
        // return max;
    }
}
