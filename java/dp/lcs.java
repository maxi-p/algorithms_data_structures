class Solution {
    int lenI, lenJ;
    int dp [][];
    String str1, str2;
    public int longestCommonSubsequence(String text1, String text2) {
        lenI = text1.length();
        lenJ = text2.length();
        str1 = text1;
        str2 = text2;
        dp = new int[lenI][lenJ];
        for(int i=0; i<lenI; i++){
            Arrays.fill(dp[i], -1);
        }
        return lcs(0,0);

    }

    public int lcs(int i, int j){
        if(i>=lenI || j>=lenJ){
            return 0;
        }
        if(i==lenI-1 && j==lenJ-1){
            if(str1.charAt(i) == str2.charAt(j)){
                dp[i][j] = 1;
            }
            else{
                dp[i][j] = 0;
            }
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        if(str1.charAt(i) == str2.charAt(j)){
            dp[i][j] = 1 + lcs(i+1, j+1);
            
        }
        else{
            dp[i][j] = Math.max(lcs(i+1,j),lcs(i,j+1));
        }

        return dp[i][j];
    }
}