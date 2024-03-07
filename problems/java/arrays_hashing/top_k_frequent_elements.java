class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int len = nums.length;
        int [] res = new int[k];

        // key - number, value - frequency
        HashMap<Integer,Integer> hash = new HashMap<>();

        // each index is the frequency. element is an array of element values
        ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
        bucket.add(new ArrayList<Integer>()); // Zeroth (unused) element
        for(int i=0; i<len;i++){
            bucket.add(new ArrayList<Integer>());
            int curVal = nums[i];
            if(hash.get(nums[i]) == null){
                hash.put(curVal,1);
            }
            else{
                hash.put(curVal, hash.get(nums[i]) + 1);
            }
        }

        // Storing the values for each frequency in the bucket
        for(Map.Entry<Integer,Integer> curSet : hash.entrySet()){
            int number = curSet.getKey();
            int freq = curSet.getValue();
            // System.out.println(number+" "+freq);

            bucket.get(freq).add(number);
        }

        
        
        int index = 0;
        int curFreq = len;
        while( k > 0 ){
            int size = bucket.get(curFreq).size();
            if( size > 0 ){
                // System.out.println(curFreq+".  "+bucket.get(curFreq));
                res[index++] = bucket.get(curFreq).get(size - 1);
                bucket.get(curFreq).remove(size - 1);
                k--;
            }
            else{
                curFreq --;
            }
        }

        return res;
    }
}