class Solution {
    int len;
    String str;
    HashSet<String> set = new HashSet<>();
    int [] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        
        len = s.length();
        dp = new int[len];
        Arrays.fill(dp,-1);
        str = s;
        for(String str : wordDict){
            set.add(str);
        }    
        return DP(0);
    }

    public boolean DP(int i){
        if(i==len){
            return true;
        }
        if(dp[i]!=-1){
            if(dp[i] == 1){
                return true;
            }
            else{
                return false;
            }
        }

        for(int j=i; j<len; j++){
            String sub = str.substring(i,j+1);
            if(set.contains(sub)){
                if(DP(j+1)){
                    dp[i] = 1;
                    return true;
                }
            }
        }
        dp[i]=0;
        return false;
    }


}