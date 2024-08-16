class Solution {
    int len;
    int [][] dp;
    int [] arr;
    public boolean canPartition(int[] nums) {
        arr = nums;
        len = nums.length;
        int sum = 0;
        int target = 0;
        for(int i=0; i<len; i++){
            sum += arr[i];
        }
        if(sum %2 == 1){
            return false;
        }
        
        target = sum/2;

        dp = new int[len][target+1];
        for(int i=0; i<len; i++){
            Arrays.fill(dp[i], -1);
        }
        if(sum(0, target) == 1){
            return true;
        }
        else{
            return false;
        }
    }

    public int sum(int i, int target){
        if(i >= len){
            return 0;
        }
        if(i == len-1){
            if(arr[i] == target || target == 0){
                dp[i][target] =1;
                return 1;
            }
            else{
                dp[i][target] = 0;
                return 0;
            }
        }
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        if (target - arr[i] > 0){
            dp[i][target] =  sum(i+1,target-arr[i]);
            if(dp[i][target] == 0){
               dp[i][target] = sum(i+1, target); 
            }
        }
        else{
            dp[i][target] = sum(i+1, target);
        }
        return dp[i][target];
        
    }
}