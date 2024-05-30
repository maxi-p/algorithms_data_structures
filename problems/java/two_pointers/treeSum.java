class Solution 
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
        List<List<Integer>> res = new ArrayList<>();
        int l,r;
        Arrays.sort(nums);
        // for (int i=0; i< nums.length; i++)
            // System.out.println(nums[i]);
        for (int i=0; i<nums.length-2; i++)
        {
            if ( i!=0 && nums[i]==nums[i-1])
                continue;
            List<List<Integer>> curRes = twoSum(i+1,nums, -nums[i]);
            // System.out.println(nums[i]);
            for(List<Integer> li : curRes)
            {
                li.add(nums[i]);
                res.add(li);
            }
        }

        return res;
    }

    public List<List<Integer>> twoSum(int l, int[] nums, int target)
    {
        // System.out.println(target);
        // key: target 
        // value: num
        int initial = l;
        HashMap<Integer,Integer> hash = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        // O(n)
        while (l<nums.length)
        {
            if( hash.containsKey(nums[l]))
            {
                // System.out.println("found: " +nums[l]+" "+hash.get(nums[l]));
                res.add(new ArrayList<>(Arrays.asList(nums[l],hash.get(nums[l]))));
                while(l<nums.length-1 && nums[l]==nums[l+1])
                    l++;
            }
            else
            {
                hash.put(target-nums[l],nums[l]);
            }
            l++;
        }

        return res;

    }
}
