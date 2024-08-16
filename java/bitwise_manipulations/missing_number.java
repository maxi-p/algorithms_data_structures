class Solution 
{
    public int missingNumber(int[] nums) 
    {
        if(nums.length == 1)
            return 1-nums[0];

        int res = nums[0];
        for(int i=1; i<nums.length; i++)
        {
            res = res ^ nums[i];
            res = res ^ i;
        }
        res = res ^ nums.length;

        return res;
    }

    // public int missingNumberNaive(int[] nums) 
    // {
    //     int len = nums.length;
    //     int res = 0;

    //     for(int i=0; i<=len; i++)
    //     {
    //         res += i;
    //     }

    //     for(int i=0; i<len; i++)
    //     {
    //         res -= nums[i];
    //     }

    //     return res;
    // }
}
