class Solution {

    public String encode(List<String> strs) {
        String res = "";
        for (String cur : strs)
        {
            res+=cur;
            res+="-";
        }
        // System.out.println(res);
        return res;   
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        String cur = "";
        for ( int i=0; i<str.length(); i++)
        {
            // System.out.println(str.charAt(i));
            if(str.charAt(i) == '-')
            {
                res.add(cur);
                cur = new String("");
            }
            else
            {
                cur+=str.charAt(i);
            }
        }

        return res;
    }
}
