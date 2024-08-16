class Solution {
    public boolean isAnagram(String s, String t) {
        System.out.println((int)'a');
        int[] hashS = new int [26];
        int[] hashT = new int [26];
        int lenS = s.length();
        int lenT = t.length();
        
        if(lenS != lenT){
            return false;
        }
        
        for(int i=0; i<lenS; i++){
            int curS = s.charAt(i)-97;
            int curT = t.charAt(i)-97;

            hashS[curS] += 1;
            hashT[curT] += 1;
        }

        for(int i=0; i<26; i++){
            if(hashS[i] != hashT[i]){
                return false;
            }
        }

        return true;
    }
}