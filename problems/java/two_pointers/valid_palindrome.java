class Solution {
    public boolean isPalindrome(String s) {
        // problem statement: case insensitive and after dropping all non-alphanums
        String str = s.toLowerCase().replaceAll("[^a-z0-9]","");
        int l=0,r=str.length()-1;
        
        while(l<r){
            if(!(str.charAt(l++) == str.charAt(r--))){
                return false;
            }
        }
        // System.out.println(str);
        return true;
    }
}