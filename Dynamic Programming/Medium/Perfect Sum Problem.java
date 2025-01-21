class Solution {
    
    private int perfectSum(int[] nums, int i, int target, int[][] dp){
        
        if(i == 0){
            if(target == 0 && nums[0] == 0){
                return 2;
            }
            else if(target == 0 || target == nums[0]){
                return 1;
            }
            return 0;
        }
        
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        
        int pick = 0;
        
        if(target - nums[i] >= 0){
            pick = perfectSum(nums, i - 1, target - nums[i], dp);
        }
        
        int notPick = perfectSum(nums, i - 1, target, dp);
        
        return dp[i][target] = pick + notPick;
        
    }
    
    // Function to calculate the number of subsets with a given sum
    public int perfectSum(int[] nums, int target) {
        // code here
        
        int[] prev = new int[target + 1];
        
        prev[0] = 1;
        
        
        for(int i = 1; i <= nums.length; i++){
            int[] curr = new int[target + 1];
            curr[0] = 1;
            for(int j = 0; j <= target; j++){
                int pick = 0;
        
                if(j - nums[i - 1] >= 0){
                    pick = prev[j - nums[i - 1]];
                }
                int notPick = prev[j];
        
                curr[j] = pick + notPick;
            }
            prev = curr;
        }
        
        return prev[target];
        
        
        
        
        
        
        
        // int[][] dp = new int[nums.length + 1][target + 1];
        
        // for(int i = 0; i <= nums.length; i++){
        //     dp[i][0] = 1;
        // }
        
        
        // for(int i = 1; i <= nums.length; i++){
        //     for(int j = 0; j <= target; j++){
        //         int pick = 0;
        
        //         if(j - nums[i - 1] >= 0){
        //             pick = dp[i - 1][j - nums[i - 1]];
        //         }
        //         int notPick = dp[i - 1][j];
        
        //         dp[i][j] = pick + notPick;
        //     }
        // }
        
        // return dp[nums.length][target];
        
        
        
        
        
        
        // int[][] dp = new int[nums.length][target + 1];
        
        // for(int i = 0; i < nums.length; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        
        // return perfectSum(nums, nums.length - 1, target, dp);
    }
}
