class Solution {
    public int rob(int[] nums) {
        // problem: maximize the sum (no conseq)
        // subproblem: rob or not + suffix
        // subpr count #n
        // choices: 2
        // solution O(n)
        int len = nums.length -1;
        int [] memo = new int[len+1];
        Arrays.fill(memo, -1);
        return dpUtil(0, len, memo, nums);

    }

    public int dpUtil(int from, int to, int[] memo, int [] nums){
        if(from > to){
            return 0;
        }
        if(memo[from] == -1){
            if(from == to){
                memo[from] = nums[from];
            }
            else{
                memo[from] = Math.max(dpUtil(from+1,to,memo,nums),nums[from]+dpUtil(from+2, to, memo, nums));
            }
        }
        
        return memo[from];

    }
}