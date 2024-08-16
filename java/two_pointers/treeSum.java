class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int l,r;
        Arrays.sort(nums);
        for (int i=0; i<nums.length-2; i++)
        {
            if ( i!=0 && nums[i]==nums[i-1])
                continue;
            twoSumSorted(i+1,nums, -nums[i],res);
        }

        return res;
    }

    void twoSumSorted(int l, int[] nums, int target, List<List<Integer>> res)
    {

        int r = nums.length-1, sum;
        // O(n)
        while (l<r)
        {
            sum = nums[l]+nums[r];

            if(sum<target)
            {
                do
                {
                    l++;
                }
                while(l<r && nums[l] == nums[l-1]);
            }
            else if (sum>target)
            {
                do
                {
                    r--;
                }
                while(l<r && nums[r] == nums[r+1]);
            }
            else /*sum == target*/
            {
                res.add(new ArrayList<>(Arrays.asList(-target, nums[l],nums[r])));
                do
                {
                    l++;
                }
                while(l<r && nums[l] == nums[l-1]);
            }
        }

    }

    // public List<List<Integer>> twoSum(int l, int[] nums, int target, List<List<Integer>> res)
    // {

    //     int initial = l;
    //     HashMap<Integer,Integer> hash = new HashMap<>();

    //     // O(n)
    //     while (l<nums.length)
    //     {
    //         if( hash.containsKey(nums[l]))
    //         {
    //             res.add(new ArrayList<>(Arrays.asList(-target, nums[l],hash.get(nums[l]))));
    //             while(l<nums.length-1 && nums[l]==nums[l+1])
    //                 l++;
    //         }
    //         else
    //         {
    //             hash.put(target-nums[l],nums[l]);
    //         }
    //         l++;
    //     }

    //     return res;
    // }
}
