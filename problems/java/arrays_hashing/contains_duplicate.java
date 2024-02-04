class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();

        int len = nums.length;

        // true if the array contains duplicates. 
        for(int i=0; i<len; i++){
            if(!hash.contains(nums[i])){
                hash.add(nums[i]);
            }
            else{
                return true;
            }
        }
        return false;
    }
}