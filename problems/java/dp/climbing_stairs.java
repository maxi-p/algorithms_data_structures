class Solution {
    public int climbStairs(int n) {
        // problem d(0, n)
        // subproblem = d(v, n)
        // guessing v! try them all
        int[] dp = new int [n];
        return dpUtil(0,n,dp);

    }
    int dpUtil(int start, int n, int [] dp){
        if(dp[start] == 0){
            if(start >= n){
                dp[start] = 0;
                return 0;
            }
            if(start == n-1){
                dp[start] = 1;
                return 1;
            }
            if(start == n-2){
                dp[start] = 2;
                return 2;
            }
            else{
                dp[start] = dpUtil(start+1,n,dp) + dpUtil(start+2,n,dp);
                return dp[start];
            }
        }
        else{
            return dp[start];
        }
    }

}