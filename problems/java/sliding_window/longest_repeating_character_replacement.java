class Solution 
{
    public int characterReplacement(String s, int k) 
    {
        // HashMap<Character, Integer> hash = new HashMap<>();
        int maxF    = 1;
        int res     = 0;
        int l       = 0;
        int r       = 0;
        int[] hash = new int[26];

        while ( r < s.length() )
        {
            int index = (int)s.charAt(r)-(int)'A';
            hash[index] += 1;
            maxF = Math.max(maxF, hash[index]);

            if ( r - l + 1 - maxF > k )
            {
                hash[(int)s.charAt(l)-(int)'A'] -= 1;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        // System.out.println("l "+l+" r "+r);

        return res;
    }
}
