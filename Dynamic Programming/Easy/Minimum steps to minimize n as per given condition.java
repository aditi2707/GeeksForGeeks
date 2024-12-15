class Solution{
    
    public int minSteps(int N, int[] dp){
        
        if(N == 1){
	        return 0;
	    }
	    
	    if(dp[N] != -1){
	        return dp[N];
	    }
	    
	    int i = 10001, j = 10001;
	    if(N % 2 == 0){
	        i = minSteps(N/2, dp);
	    }
	    if(N % 3 == 0){
	        j = minSteps(N/3, dp);
	    }
	    int k = minSteps(N - 1, dp);
	    
	    dp[N] = 1 + Math.min(i, Math.min(j, k));
	    return dp[N];
    }

	public int minSteps(int N) 
	{ 
	    int[] dp = new int[N + 1];
	    
	    for(int i = 2; i <= N; i++){
	        
	        int a = 10001, b = 10001;
	        if(i % 2 == 0){
	            a = dp[i / 2];
	        }
	        if(i % 3 == 0){
	            b = dp[i / 3];
	        }
	        int c = dp[i - 1];
	    
	        dp[i] = 1 + Math.min(a, Math.min(b, c));
	    }
	    
	    return dp[N];
	    
	    
	    
	    
	  
	   // int[] dp = new int[N + 1];
	   // Arrays.fill(dp, -1);
	    
	   // return minSteps(N, dp);
	}
}
