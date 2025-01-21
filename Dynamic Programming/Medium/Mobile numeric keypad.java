class Solution {
    
    private long mobileKeypad(int[][] press, int i, int steps, long[][] dp){
        
        if(steps == 0){
            return 1;
        }
        
        if(dp[i][steps] != -1){
            return dp[i][steps];
        }
        
        long count = 0;
        
        for(Integer j: press[i]){
            count += mobileKeypad(press, j, steps - 1, dp);
        }
        
        return dp[i][steps] = count;
    }
    
    
    public long getCount(int n) {
        // Your code goes here
        
        int[][] press = {
            {0, 8},
            {1, 2, 4},
            {2, 1, 3, 5},
            {3, 2, 6},
            {4, 1, 5, 7},
            {5, 2, 4, 6, 8},
            {6, 3, 5, 9},
            {7, 4, 8},
            {8, 7, 5, 9, 0},
            {9, 6, 8}
        };
        
        long count = 0;
        long[] prev = new long[10];
        
        for(int i = 0; i < 10; i++){
            prev[i] = 1;
        }
        
        for(int i = 1; i < n; i++){
            long[] curr = new long[10];
            for(int j = 0; j < 10; j++){
                long c = 0;
                for(Integer k: press[j]){
                    c += prev[k];
                }
                curr[j] = c;
            }
            prev = curr;
        }
        
        for(int j = 0; j < 10; j++){
            count += prev[j];
        }
        
        return count;
        
        
        
        
        
        
        
        // int[][] press = {
        //     {0, 8},
        //     {1, 2, 4},
        //     {2, 1, 3, 5},
        //     {3, 2, 6},
        //     {4, 1, 5, 7},
        //     {5, 2, 4, 6, 8},
        //     {6, 3, 5, 9},
        //     {7, 4, 8},
        //     {8, 7, 5, 9, 0},
        //     {9, 6, 8}
        // };
        
        // long count = 0;
        // long[][] dp = new long[n][10];
        
        // for(int i = 0; i < 10; i++){
        //     dp[0][i] = 1;
        // }
        
        // for(int i = 1; i < n; i++){
        //     for(int j = 0; j < 10; j++){
        //         long c = 0;
        //         for(Integer k: press[j]){
        //             c += dp[i - 1][k];
        //         }
        //         dp[i][j] = c;
        //     }
        // }
        
        // for(int j = 0; j < 10; j++){
        //     count += dp[n - 1][j];
        // }
        
        // return count;
        
        
        
        
        
        
        // int[][] press = {
        //     {0, 8},
        //     {1, 2, 4},
        //     {2, 1, 3, 5},
        //     {3, 2, 6},
        //     {4, 1, 5, 7},
        //     {5, 2, 4, 6, 8},
        //     {6, 3, 5, 9},
        //     {7, 4, 8},
        //     {8, 7, 5, 9, 0},
        //     {9, 6, 8}
        // };
        
        // long count = 0;
        // long[][] dp = new long[10][n];
        
        // for(int i = 0; i < 10; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // for(int i = 0; i < 10; i++){
        //     count += mobileKeypad(press, i, n - 1, dp);
        // }
        
        // return count;
    }
}
