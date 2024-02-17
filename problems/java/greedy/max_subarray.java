class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curSum = nums[0];

        for(int i=1; i<nums.length; i++){
            if(curSum < 0){
                curSum = 0;
            }
            curSum += nums[i];
            max = Math.max(max, curSum);
        }

        return max;
    }
}