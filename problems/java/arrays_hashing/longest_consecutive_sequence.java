class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
    	int res = 0;
    	if (nums == null) return 0;

    	for (int num: nums){
    		set.add(num);
        }

        for (int num: nums){
            int firstNum = num;
        	if(!set.contains(num-1)){
                while(set.contains(num)){
                    set.remove(num);
                	num++;
                }
                res = Math.max(res,(num-firstNum));
            }
        }

    	return res;
    }
}
