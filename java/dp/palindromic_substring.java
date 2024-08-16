class Solution {
    String res = new String("");
    public String longestPalindrome(String s) {
        
        int len = s.length();
        int[][] dp = new int[len][len];
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i],-1);
        }
        dpUtil(0,len-1,dp,s);

        return res; 
    }
    public int dpUtil(int i, int j, int[][] dp, String s){
        if( i<0 || i>= s.length()){
            return 0;
        }
        if( j<0 || j>= s.length()){
            return 0;
        }
        if(i>j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i==j){
            dp[i][j] = 1;
            if(res.length() < 1){
                res = s.substring(i,j+1);
            }
            return 1;
        }
        if(i+1 == j){
            if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = 2;
                if(res.length() < 2){
                    res = s.substring(i,j+1);
                }
                return 2;
            }
            else{
                if(res.length() < 1){
                    res = s.substring(i,j);
                }
                return 1;
            }
        }

        //this size
        int sub = dpUtil(i+1,j-1,dp,s);
        if(sub == (j-i-1) && s.charAt(i) == s.charAt(j)){
            dp[i][j] = 2+sub;
            if(dp[i][j]>res.length()){
                res = s.substring(i,j+1);
            }
        }
        else{
            dp[i][j] = Math.max(dpUtil(i+1,j,dp,s),dpUtil(i,j-1,dp,s));
        }

        return dp[i][j];

    }

}