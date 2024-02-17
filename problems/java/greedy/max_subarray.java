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

// VERSION with printing the resulting optimal subarray

// class Solution {
//     public int maxSubArray(int[] nums) {
//         int max = nums[0];
//         int curSum = nums[0];
//         int start = 0;
//         int end = 0;

//         for(int i=1; i<nums.length; i++){
//             if(curSum < 0){
//                 curSum = 0;
//                 start = i;
//             }
//             curSum += nums[i];
//             max = Math.max(max, curSum);
//             end = i;
//         }
//         for(int i = start; i<=end; i++){
//             System.out.print(nums[i]+" ");
//         }

//         return max;
//     }
// }