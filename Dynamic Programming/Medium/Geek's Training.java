class Solution {
    
    private int geekTraining(int[][] arr, int m, int n, int[][] dp){
        
        if(m >= arr.length){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int max = 0;
        
        for(int i = 0; i < 3; i++){
            if(i != n){
                max = Math.max(max, arr[m][i] + geekTraining(arr, m + 1, i, dp));
            }
        }
        
        dp[m][n] = max;
        
        return dp[m][n];
    }
    
    
    public int maximumPoints(int arr[][]) {
        // code here
        
        int[] prev= new int[4];
        
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        
        for(int i = 1; i < arr.length; i++){
            int[] curr = new int[4];
            for(int j = 0; j < 4; j++){
                int max = 0;
                for(int k = 0; k < 3; k++){
                    if(k != j){
                        max = Math.max(max, arr[i][k] + prev[k]);
                    }
                }
                curr[j] = max;
            }
            prev = curr;
        }
        
        return prev[3];
        
        
        
        
        
        
        
        // int fMax = 0;
        // int[][] dp = new int[arr.length][4];
        
        // dp[0][0] = Math.max(arr[0][1], arr[0][2]);
        // dp[0][1] = Math.max(arr[0][0], arr[0][2]);
        // dp[0][2] = Math.max(arr[0][0], arr[0][1]);
        // dp[0][3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        
        // for(int i = 1; i < arr.length; i++){
        //     for(int j = 0; j < 4; j++){
        //         int max = 0;
        //         for(int k = 0; k < 3; k++){
        //             if(k != j){
        //                 max = Math.max(max, arr[i][k] + dp[i - 1][k]);
        //             }
        //         }
        //         dp[i][j] = max;
        //     }
        // }
        
        // return dp[arr.length - 1][3];
        
        
        
        
        
        
        
        
        // int max = 0;
        // int[][] dp = new int[arr.length][3];
        
        // for(int i = 0; i < arr.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // for(int i = 0; i < 3; i++){
        //     max = Math.max(max, geekTraining(arr, 0, i, dp));
        // }
        
        // return max;
    }
}
