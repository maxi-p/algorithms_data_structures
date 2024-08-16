class Solution {
    public int count = 0;
    public int countSubstrings(String s) {
        int len = s.length();
        int [][] dp = new int[len][len];
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i],-1);
        }
        dpUtil(0,len-1,s,dp);
        
        return count;
    }

    public int dpUtil(int i, int j, String s, int [][]dp){
        if(i<0 || i>=s.length()){
            return 0;
        }
        if(j<i || j>=s.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }  
        if(i == j){
            dp[i][j] = 1;
            // System.out.println(i+""+j+1);
            count += 1;
            return 1;
        }
        if(i+1 == j){
            dpUtil(i,j-1,s,dp);
            dpUtil(i+1,j,s,dp);

            if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = 2;
                // System.out.println(i+""+j+1);
                count+=1;
                return 2;
            }
            else{
                dp[i][j] = 1;
                return 1;
            }
        }

        dp[i][j] = Math.max(dpUtil(i+1,j,s,dp),dpUtil(i,j-1,s,dp));
        int sub = dpUtil(i+1, j-1, s, dp);
        // if(i==0 && j==4){
        //     // System.out.println("YO "+sub);
        // }
        if(sub == j-i-1){
            if(s.charAt(i) == s.charAt(j)){
                dp[i][j] = 2+sub;
                // System.out.println(i+""+j+1);
                count +=1;
            }
            else{
                dp[i][j] = sub;
            }
        }

        
        return dp[i][j];
    }
    

}