class Solution {
    public int rob(int[] nums) {
        // subproblem: suffix, nums[i:]
        int len = nums.length;
        int [] dp = new int[nums.length];
        int [] dp2 = new int[nums.length];
        Arrays.fill(dp, -1);
        Arrays.fill(dp2, -1);
        boolean first = false;
        if(len == 1){
            return nums[0];
        }
        return Math.max(dpUtil(0,len-1,nums,dp),dpUtil(1,len, nums,dp2));

    }

    public int dpUtil(int i, int j, int[]nums, int []dp){
        int len = j;
        if(i >= len){
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        
        if(i == len-1){
            dp[i] = nums[i];
        }

        else{
            int dont = dpUtil(i+1,j, nums,dp);
            int include = nums[i]+dpUtil(i+2,j,nums,dp);
            dp[i] = Math.max(dont, include);

        }
        return dp[i];
    }
}