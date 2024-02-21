public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int j = 1;
        int count = 0;
        for(int i=0; i<32;i++){
            // System.out.println(Integer.toString(j,2));
            // System.out.println(Integer.toString(n,2));
            // System.out.println();
            if((n & j) >> i == 1){
                // System.out.println(i);
                count ++;
            }
            if(i == 31 && n < 0){
                count++;
            }
            j = j << 1;
        }

        return count;
    }
}