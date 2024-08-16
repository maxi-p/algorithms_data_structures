class Solution 
{
    public String minWindow(String s, String t) 
    {
        int[]   hash    = new int[128];
        int[]   curHash = new int[128];
        int     gMin    = Integer.MAX_VALUE;
        int     need    = t.length();
        int     have    = 0;
        int     l       = 0;
        int     r       = 0;
        int     lMin    = 0;
        int     rMin    = -1;

        for (int i=0; i<t.length(); i++)
                hash[t.charAt(i)]++;
        
        while(r<s.length())
        {
            Character curChar = s.charAt(r);
            curHash[curChar]++;
            if (hash[curChar] >= curHash[curChar])
                have++;

            while (have>=need)
            {
                if(r-l+1 <= gMin)
                {
                    gMin = r-l+1;
                    lMin = l;
                    rMin = r;
                    // sMin = s.substring(l,r+1);
                }
                Character   remChar = s.charAt(l);
                int         curFreq = curHash[remChar];
                l++;          
                
                curHash[remChar]--;
                if (hash[remChar] > curFreq-1)
                    have--;
            }
            r++;
        }

        if (rMin == -1)
            return "";
        return s.substring(lMin,rMin+1);
    }

    // public String minWindow(String s, String t) 
    // {
    //     HashMap<Character, Integer> hash     = new HashMap<>();
    //     HashMap<Character, Integer> curHash  = new HashMap<>();

    //     for (int i=0; i<t.length(); i++)
    //     {
    //         if ( hash.containsKey(t.charAt(i)) )
    //             hash.put(t.charAt(i),hash.get(t.charAt(i))+1);
    //         else
    //             hash.put(t.charAt(i), 1);
    //     }

    //     int     l = 0;
    //     int     r = 0;
    //     int     gMin = Integer.MAX_VALUE;
    //     String  sMin = "";
        
    //     while(r<s.length())
    //     {
    //         if(curHash.containsKey(s.charAt(r)))
    //             curHash.put(s.charAt(r), curHash.get(s.charAt(r))+1);
    //         else
    //             curHash.put(s.charAt(r),1);

    //         if(goodFreq(curHash, hash))
    //         {
    //             while(true)
    //             {
    //                 if(r-l+1 <= gMin)
    //                 {
    //                     gMin = r-l+1;
    //                     sMin = s.substring(l,r+1);
    //                 }
    //                 int         curFreq = curHash.get(s.charAt(l));
    //                 Character   remChar = s.charAt(l);
    //                 l++;          
    //                 if(curFreq == 1)
    //                 {
    //                     curHash.remove(remChar);
    //                     if (hash.containsKey(remChar))
    //                         break;
    //                 }
    //                 else
    //                 {
    //                     curHash.put(remChar,curFreq-1);
    //                     if (hash.containsKey(remChar) && hash.get(remChar) > curFreq-1)
    //                         break;
    //                 }
    //             }
    //         }
    //         r++;
    //     }

    //     return sMin;
    // }

    // public boolean goodFreq(HashMap<Character,Integer> big, HashMap<Character,Integer> small)
    // {
    //     for(Map.Entry<Character,Integer> set: small.entrySet())
    //     {
    //         if (!big.containsKey(set.getKey()) || big.get(set.getKey())<set.getValue() )
    //             return false;
    //     }
    //     return true;
    // }
}
