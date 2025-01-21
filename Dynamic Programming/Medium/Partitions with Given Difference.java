class Solution {
    
    private int subsetWithDiff(int[] arr, int i, int target, int[][] dp){
     
        if(i == 0){
            if(target == 0 && arr[0] == 0){
                return 2;
            }
            else if(target == 0 || target == arr[0]){
                return 1;
            }
            return 0;
        }
        
        if(target < 0){
            return 0;
        }
        
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        
        int pick = subsetWithDiff(arr, i - 1, target - arr[i], dp);
        int notPick = subsetWithDiff(arr, i - 1, target, dp);
        
        return dp[i][target] = pick + notPick;
        
    }
    
    int countPartitions(int[] arr, int d) {
        // code here
        
        int total = 0;
        
        for(Integer i: arr){
            total += i;
        }
        
        if((total - d) % 2 != 0 || total < d){
            return 0;
        }
        
        int[] prev = new int[(total - d) / 2 + 1];
        
        prev[0] = 1;
        
        for(int i = 1; i <= arr.length; i++){
            int[] curr = new int[(total - d) / 2 + 1];
            for(int j = 0; j <= (total - d) / 2; j++){
                int pick = 0;
        
                if(j - arr[i - 1] >= 0){
                    pick = prev[j - arr[i - 1]];
                }
                int notPick = prev[j];
        
                curr[j] = pick + notPick;
            }
            prev = curr;
        }
        
        return prev[(total - d) / 2];
        
        
        
        
        
        
        
        // int total = 0;
        
        // for(Integer i: arr){
        //     total += i;
        // }
        
        // if((total - d) % 2 != 0 || total < d){
        //     return 0;
        // }
        
        // int[][] dp = new int[arr.length + 1][(total - d) / 2 + 1];
        
        // for(int i = 0; i <= arr.length; i++){
        //     dp[i][0] = 1;
        // }
        
        // for(int i = 1; i <= arr.length; i++){
        //     for(int j = 0; j <= (total - d) / 2; j++){
        //         int pick = 0;
        
        //         if(j - arr[i - 1] >= 0){
        //             pick = dp[i - 1][j - arr[i - 1]];
        //         }
        //         int notPick = dp[i - 1][j];
        
        //         dp[i][j] = pick + notPick;
        //     }
        // }
        
        // return dp[arr.length][(total - d) / 2];
        



        
        
        // int total = 0;
        
        // for(Integer i: arr){
        //     total += i;
        // }
        
        // if((total - d) % 2 != 0 || total < d){
        //     return 0;
        // }
        
        // int[][] dp = new int[arr.length][(total - d) / 2 + 1];
        
        // for(int i = 0; i < arr.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return subsetWithDiff(arr, arr.length - 1, (total - d) / 2, dp);
    }
}
