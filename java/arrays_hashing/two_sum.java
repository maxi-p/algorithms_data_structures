class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        int[] res = new int[2];
        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int i=0; i<len; i++){
            int cur = target - nums[i];

            if(hash.get(cur) != null){
                res[0] = hash.get(cur);
                res[1] = i;
                return res;
            }
            else{
                hash.put(nums[i],i);
            }
        }
        return res;
    }
}