class Solution {
    
    private static boolean subsetSum(int[] arr, int target, int i, int[][] dp){
        
        if(target == 0){
            return true;
        }
        if(i < 0 || target < 0){
            return false;
        }
        
        if(dp[i][target] != -1){
            return dp[i][target] == 1;
        }
        
        boolean pick = subsetSum(arr, target - arr[i], i - 1, dp);
        if(pick){
            return true;
        }
        
        boolean notPick = subsetSum(arr, target, i - 1, dp);
        
        boolean result = pick || notPick;
        if(result){
            dp[i][target] = 1;
        }
        
        return result;
    }

    static Boolean isSubsetSum(int arr[], int target) {
        // code here
        
        boolean[] prev = new boolean[target + 1];
        prev[0] = true;
        
        for(int i = 1; i <= target; i++){
            prev[i] = false;
        }
        
        for(int i = 1; i <= arr.length; i++){
            boolean[] curr = new boolean[target + 1];
            curr[0] = true;
            for(int j = 1; j <= target; j++){
                boolean pick = false;
                if(j - arr[i - 1] >= 0){
                    pick = prev[j - arr[i - 1]];
                }
        
                boolean notPick = prev[j];
        
                curr[j] = pick || notPick;
            }
            prev = curr;
        }
        
        return prev[target];
        
        
        
        
        
        
        
        // boolean[][] dp = new boolean[arr.length + 1][target + 1];
        
        // for(int i = 0; i <= arr.length; i++){
        //     dp[i][0] = true;
        // }
        // for(int i = 1; i <= target; i++){
        //     dp[0][i] = false;
        // }
        
        // for(int i = 1; i <= arr.length; i++){
        //     for(int j = 1; j <= target; j++){
        //         boolean pick = false;
        //         if(j - arr[i - 1] >= 0){
        //             pick = dp[i - 1][j - arr[i - 1]];
        //         }
        
        //         boolean notPick = dp[i - 1][j];
        
        //         dp[i][j] = pick || notPick;
        //     }
        // }
        
        // return dp[arr.length][target];
        
        
        
        
        
        
        
        // int[][] dp = new int[arr.length][target + 1];
        
        // for(int i = 0; i < arr.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return subsetSum(arr, target, arr.length - 1, dp);
    }
}
