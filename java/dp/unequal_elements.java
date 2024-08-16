import java.util.Arrays;

public class unequal_elements {
    public static int[] skills = {1,1,2,3,2,1};
    public static int[][] dp;
    public static void main(String [] args){
        // System.out.println(skills.length);
        int len = skills.length;
        int k= 2;
        dp = new int[len][k+1];
        for(int i=0; i<len;i++){
            Arrays.fill(dp[i],-1);
        } 
        System.out.println(longestSeq(0, k));
    }
    // 1 + 1 + 1 + 1 + 
    // 1,1,2,3,2,1
    public static int longestSeq(int i, int k){  
        if(i == skills.length-1)
            return 1;

        if(dp[i][k]!=-1)
            return dp[i][k];

        if(i+1 < skills.length -1 && skills[i] == skills[i+1])
            dp[i][k] = 1 + longestSeq(i+1,k);
        else{
            int use = 1;
            if(k>0)
                use = 1+longestSeq(i+1,k-1);

            int j = i+1;
            while(j < skills.length && skills[i] != skills[j]){
                j++;
            }

            if(j<skills.length)
                use = Math.max(1 + longestSeq(j,k),use);
            
            dp[i][k] = use;
        }

        return dp[i][k];

    }
}