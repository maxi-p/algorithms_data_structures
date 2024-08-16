class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int l = 0;
        int r = 0;

        while ( r < s.length() )
        {
            if (set.contains(s.charAt(r)))
            {
                
                set.remove(s.charAt(l));
                l++;
                continue;
            }
            else
            {
                set.add(s.charAt(r));
                r++;
            }
            max = Math.max(max, r-l);
        }


        return max;
    }
}
