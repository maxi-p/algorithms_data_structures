
class Solution {
    public String str1;
    public String str2;
    public char[][][][] dp;
    public int count = 0;

    public int countSubstrings(String s, String t) {
        //ab
        //cb

        str1 = s;
        str2 = t;
        
        int len1 = str1.length();
        int len2 = str2.length();
        dp = new char[len1][len1][len2][len2];
        dpUtil(0,len1-1,0,len2-1);
        return count;

    }
    // 0 off by more/error
    // 1 identical 
    // 2 off by 1 
    public char dpUtil(int i, int j, int a, int b){
        // System.out.println("asd");
        if(i<0 || i>=str1.length()){
            // System.out.println("???");
            return '0';
        }

        if(j<i || j>=str1.length()){
            // System.out.println("???");
            return '0';
        }
        if(a<0 || a>=str2.length()){
            // System.out.println("???");
            return '0';
        }

        if(b<a || b>=str2.length()){
            // System.out.println("???");
            return '0';
        }
        if(dp[i][j][a][b] != 0){
            return dp[i][j][a][b];
        }
        if(j == i && a == b){
            if(str1.charAt(j) == str2.charAt(b)){
                dp[i][j][a][b] = '1';
                return '1';
            }
            else{
                dp[i][j][a][b] = '2';
                // System.out.println(str1.substring(i,j+1)+" "+str2.substring(a,b+1));
                // System.out.println(i+" "+j+" "+a+" "+b);
                count++;
                return '2';
            }
        }

        if(j-i > b-a){
            // System.out.println("str1 > str2");
            dpUtil(i+1,j,a,b);
            dpUtil(i,j-1,a,b);
        }
        else if(j-i < b-a){
            // System.out.println("str1 < str2");
            dpUtil(i,j,a+1,b);
            dpUtil(i,j,a,b-1);
        }
        // "babab"
        // "babab"
        else{
            // System.out.println("str1 == str2");
            
            char sub = dpUtil(i+1,j,a+1,b);
            if(str1.charAt(i) == str2.charAt(a)){ 
                
                if(sub == '1'){
                    dp[i][j][a][b] = '1';
                }
                else if(sub == '2'){
                    dp[i][j][a][b] = '2';
                    // System.out.println(str1.substring(i,j+1)+" "+str2.substring(a,b+1));
                    // System.out.println(i+" "+j+" "+a+" "+b);
                    count++;
                }
                // sub == 0
                else{
                    dp[i][j][a][b] = '0';
                }
            }
            // str1.charAt(i) != str2.charAt(a)
            else{
                if(sub == '1'){
                    dp[i][j][a][b] = '2';
                    // System.out.println(str1.substring(i,j+1)+" "+str2.substring(a,b+1));
                    // System.out.println(i+" "+j+" "+a+" "+b);
                    count++;
                }
                //sub == 2 || sub == 0
                else{
                    dp[i][j][a][b] = '0';
                }
            }

            dpUtil(i,j-1,a,b-1);
            dpUtil(i+1,j,a,b-1);
            dpUtil(i,j-1,a+1,b);
        }
        // System.out.println(i+""+j+a+b);
        // System.out.println(dp[i][j][a][b]);
        return dp[i][j][a][b];
    }
}