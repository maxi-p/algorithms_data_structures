class Solution {
    static List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        ArrayList<Integer> cur = new ArrayList<>();
        getSubset(cur, nums, 0);
        return res;
        // [1, 2, 2]
        // sol = [[1,2,2], [1,2], [1], [2,2], [2], []]
        // i = 0   
        // cur = []
    }

    public void getSubset(ArrayList<Integer> curSet, int[] nums, int i){
        if (i == nums.length) {
            res.add((List)curSet.clone());
            return;
        }
        
        curSet.add(nums[i]);
        getSubset(curSet, nums, i+1);
        curSet.remove(curSet.size()-1);
        while(i < nums.length-1 && nums[i] == nums[i+1]){
            i++;
        }
        getSubset(curSet, nums, i+1);

        
    }
}
