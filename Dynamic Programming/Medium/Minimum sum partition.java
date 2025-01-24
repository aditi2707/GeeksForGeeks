class Solution {
    
    private boolean minSumPart(int[] arr, int i, int total, int[][] dp){
        
        if(total == 0){
            return true;
        }
        if(i == 0){
            if(total == arr[0]){
                dp[0][total] = 1;
            }
            else{
                dp[0][total] = 0;
            }
            return total == arr[0];
        }
        
        if(dp[i][total] != -1){
            return dp[i][total] == 1;
        }
        
        boolean notPick = minSumPart(arr, i - 1, total, dp);
        boolean pick = false;
        
        if(total - arr[i] >= 0){
            pick = minSumPart(arr, i - 1, total - arr[i], dp);
        }
        
        boolean res = pick || notPick;
        
        if(res){
            dp[i][total] = 1;
        }
        else{
            dp[i][total] = 0;
        }
        
        return res;
    }

    public int minDifference(int arr[]) {
        // Your code goes here
        
        int total = 0;
        int min = Integer.MAX_VALUE;
        
        for(Integer i: arr){
            total += i;
        }
        
        boolean[] prev = new boolean[total + 1];
        
        prev[0] = true;
        
        if(total <= arr[0]){
            prev[arr[0]] = true;
        }
        
        for(int i = 1; i < arr.length; i++){
            boolean[] curr = new boolean[total + 1];
            curr[0] = true;
            for(int j = 1; j <= total; j++){
                
                boolean notPick = prev[j];
                boolean pick = false;
        
                if(j - arr[i] >= 0){
                    pick = prev[j - arr[i]];
                }
        
                curr[j] = pick || notPick;
            }
            prev = curr;
        }
        
        for(int i = 0; i <= total; i++){
            if(prev[i]){
                min = Math.min(min, Math.abs(total - (2 * i)));
            }
        }
        
        return min;
        
        
        
        
        
        
        // int total = 0;
        // int min = Integer.MAX_VALUE;
        
        // for(Integer i: arr){
        //     total += i;
        // }
        
        // boolean[][] dp = new boolean[arr.length][total + 1];
        
        // for(int i = 0; i < arr.length; i++){
        //     dp[i][0] = true;
        // }
        
        // if(total <= arr[0]){
        //     dp[0][arr[0]] = true;
        // }
        
        // for(int i = 1; i < arr.length; i++){
        //     for(int j = 1; j <= total; j++){
                
        //         boolean notPick = dp[i - 1][j];
        //         boolean pick = false;
        
        //         if(j - arr[i] >= 0){
        //             pick = dp[i - 1][j - arr[i]];
        //         }
        
        //         dp[i][j] = pick || notPick;
        //     }
        // }
        
        // for(int i = 0; i <= total; i++){
        //     if(dp[arr.length - 1][i]){
        //         min = Math.min(min, Math.abs(total - (2 * i)));
        //     }
        // }
        
        // return min;
        
        
        
        
        
        
        // int total = 0;
        // int min = Integer.MAX_VALUE;
        
        // for(Integer i: arr){
        //     total += i;
        // }
        
        // int[][] dp = new int[arr.length][total + 1];
        
        // for(int i = 0; i < arr.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // for(int i = 0; i <= total; i++){
        //     minSumPart(arr, arr.length - 1, i, dp);
        // }
        
        // for(int i = 0; i <= total; i++){
        //     if(dp[arr.length - 1][i] == 1){
        //         min = Math.min(min, Math.abs(total - (2 * i)));
        //     }
        // }
        
        // return min;
    }
}
