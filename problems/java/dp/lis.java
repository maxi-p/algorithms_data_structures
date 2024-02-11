class Solution {
    int len;
    int dp[];
    int arr[];
    public int lengthOfLIS(int[] nums) {
        len = nums.length;
        dp = new int[len];
        Arrays.fill(dp,-1);
        arr = nums;
        for(int j=0; j<len;j++){
            lisStartingWith(j);
        }
        int max = 1;
        for(int j=0; j<len; j++){
            max = Math.max(max, dp[j]);
        }
        return max;
        
    }
    public int lisStartingWith(int i){
        if(i == len-1){
            dp[i]=1;
            return dp[i];
        }

        if(dp[i]!=-1){
            return dp[i];
        }
        dp[i] = 1;
        for(int j=i+1;j<len;j++){
            if(arr[i]<arr[j]){
                dp[i] = Math.max(dp[i],1+lisStartingWith(j));
            }
        }
        return dp[i];
    }
}