class Solution {
    int [] arr;
    int [] dp;
    public int jump(int[] nums) {
        arr = nums;
        dp = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int res = min(0);
        return res;
    }

    public int min(int i){
        if(i >= arr.length){
            return 0;
        }
        if(i==arr.length-1){
            dp[i] = 0;
            return 0;
        }
        if(dp[i] != Integer.MAX_VALUE){
            return dp[i];
        }
        int cur = arr[i];
        for(int j=cur; j>0; j--){
            // System.out.print(j+" "+dp[i]+" ");
            int sub = min(i+j);
            dp[i] = Math.min(dp[i],1+min(i+j));
        }
        if(dp[i] == Integer.MAX_VALUE){
            dp[i] = Integer.MAX_VALUE-1;
        }

        return dp[i];
    }
}