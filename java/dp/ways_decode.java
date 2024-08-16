class Solution {
    public String str;
    int[] dp;
    public int numDecodings(String s) {
        str = s;
        int len = s.length();
        dp = new int[len];
        Arrays.fill(dp,-1);
        return dpUtil(0);
    }

    public int dpUtil(int i){
        if(i>=str.length()){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        if(i == str.length()-1){
            int val = Integer.valueOf(str.substring(i,i+1));
            if(val == 0){
                dp[i]=0;
                return 0;
            }
            dp[i] = 1;
            return 1;
        }
        if(i == str.length()-2){
            int single_value =Integer.valueOf(str.substring(i,i+1));
            if(single_value == 0){
                dp[i] = 0;
                return 0;
            }
            int value = Integer.valueOf(str.substring(i));
            if(value <= 26){
                int ten_edge_case =Integer.valueOf(str.substring(i+1,i+2));
                if(ten_edge_case == 0){
                    dp[i] = 1;
                    return 1;
                }
                dp[i] = 2;
                return 2;
            }
            else{
                int zero_edge_case =Integer.valueOf(str.substring(i+1,i+2));
                if(zero_edge_case == 0){
                    dp[i] = 0;
                    return 0;
                }
                dp[i] = 1;
                return 1;
            }
        }
        
        int one = dpUtil(i+1);
        int two = dpUtil(i+2);
        
        int val = Integer.valueOf(str.substring(i,i+2));
        // System.out.println(val);

        int single_val = Integer.valueOf(str.substring(i,i+1));
        if(single_val == 0){
            one = 0;
            two = 0;
        }
        
        if(val >26){
            two = 0;
        }
        // System.out.println(i+": "+one+" "+two);
        dp[i] = one + two;
        return dp[i];
    } 


}