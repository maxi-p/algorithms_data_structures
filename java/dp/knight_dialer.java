
class Solution {
    int [][] moves = {{5,7},{6,8},{3,7},{2,8,10},{},{0,6,10},{1,5},{0,2},{1,3},{},{3,5},{}};
    long [] dp = {2,2,2,3,0,3,2,2,2,0,2,0};
    long [][] dp1;
    
    public int knightDialer(int n) {
        long count = 0;
        dp1 = new long[12][n];
        for(int i=0;i<12;i++){
            Arrays.fill(dp1[i],-1);
        }
        for(int i=0;i<12;i++){
            count = count %1000000007+ dpUtil(i,n-1)%1000000007;
        }
        return (int)count%1000000007;     
    }

    public long dpUtil(int i, int n){
        if(i == 9 || i == 11){
            return 0;
        }
        if(n == 0){
            return 1;
        }

        if(dp1[i][n] != -1){
            return dp1[i][n];
        }

        long count = 0;
        for(int x=0;x<dp[i];x++){
            count += dpUtil(moves[i][x],n-1)%1000000007;
        }
        dp1[i][n] = count;
        
        return dp1[i][n];
    }


}