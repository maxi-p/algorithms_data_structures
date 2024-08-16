class Solution 
{
    public List<List<String>> groupAnagrams(String[] strs){
	    if (strs == null)	return null;
	    List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> hash = new HashMap<>();

        for (String str : strs){
        	char[] chars = str.toCharArray();
        	Arrays.sort(chars);
        	String sorted = new String(chars).toString();
        	if (hash.containsKey(sorted)){
        		List<String> list = hash.get(sorted);
        		list.add(str);
            }
            else{
            	List<String> newList = new ArrayList<>();
            	newList.add(str);
            	hash.put(sorted, newList);
            }
        }

        for (Map.Entry<String, List<String>> set : hash.entrySet()){
        	res.add(set.getValue());
        }

	    return res;
    }

}
