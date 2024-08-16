class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;
        if(nums[0] < nums[len-1]){
            return nums[0];
        }

        int min = 0, max = len - 1;
        int res = nums[min];
        int mid = 0;

        while(min < max){
            mid = (max + min)/2;
            res = Math.min(res, nums[min]);

            if( nums[min] > nums[mid]){
                max = mid;
            }
            else{
                min = mid + 1;
            }
        }

        res = Math.min(res, nums[min]);
        
        return res;
    }
}