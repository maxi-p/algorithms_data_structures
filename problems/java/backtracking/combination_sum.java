// beats 99% of Java users
class Solution 
{
    public List<List<Integer>> combSum;
    public List<List<Integer>> combinationSum(int[] candidates, int target) 
    {
        combSum = new ArrayList<>();
        backtr(candidates, target, new ArrayList<Integer>(), 0);
        return combSum;
    }
    public void backtr (int[] nums, int target, List<Integer> cur, int index)
    {
        for ( int i=index; i < nums.length; i++)
        {
            if ( nums[i] < target )
            {
                cur.add(nums[i]);
                backtr(nums, target-nums[i],cur, i);
                cur.remove(cur.size()-1);
            }
            else if ( nums[i] == target )
            {
                List<Integer> member = new ArrayList<Integer>();
                cur.add(nums[i]);
                for ( int j=0; j<cur.size(); j++)
                {
                    member.add(cur.get(j));
                }
                combSum.add(member);
                cur.remove(cur.size()-1);
            }
        }
    }
}
