class Solution {
    int dp[][];
    int len;
    int [][] copy;
    int min = Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        len = matrix.length;
        copy = matrix;
        dp = new int [len][len];
        for(int i=0; i<len;i++){
            Arrays.fill(dp[i], -101);
        }
        for(int i=0; i<len;i++){
            dpUtil(0,i);
            min = Math.min(dp[0][i],min);
        }

        // for(int i=0;i<len;i++){
        //     for(int j=0; j<len;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     // System.out.println("");
            
        // }
        return min;

    }

    public int dpUtil(int i, int j){
        if(i<0 || i>=len || j<0 || j>=len){
            return Integer.MAX_VALUE;
        }
        if(i == len-1){
            dp[i][j] = copy[i][j];
            return dp[i][j];
        }
        if(dp[i][j] != -101){
            return dp[i][j];
        }
        
        int temp = Math.min(dpUtil(i+1,j),dpUtil(i+1,j+1));
        dp[i][j] = copy[i][j] + Math.min(dpUtil(i+1,j-1),temp);
        if(i==1 && j == 2){
            // System.out.println(temp);
        }

        return dp[i][j];

    }
}