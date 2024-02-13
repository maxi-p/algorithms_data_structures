class Solution {
    int [][] dp;
    int row; 
    int col;

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        row = m;
        col = n;
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(0,0);
    }
    public int path(int i, int j){
        if(i>=row || j >= col ){
            return 0;
        }
        if (i == row-1 && j == col-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        dp[i][j] = path(i+1,j) + path(i,j+1);
        return dp[i][j];
    }
}