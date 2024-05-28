class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int res2 = 1;
        // int[] res2 = new int[nums.length];
        // Arrays.fill(res,1);
        // Arrays.fill(res2,1);

        for ( int i=0; i<nums.length; i++)
        {
            if(i==0)
            {
                res[i]=1;
                continue;
            }
            
            res[i] = res[i-1] * nums[i-1];
            // System.out.println(res[i]);
        }

        for ( int i=nums.length-1; i>=0; i--)
        {
            if(i==nums.length-1)
            {
                continue;
            }
            
            res2 = res2 * nums[i+1];
            res[i] *= res2;
            // System.out.println(res2[i]);
        }

        return res;
    }
}
