import java.util.Arrays;

public class efficient_cost{
    public static int[] arr = {1,3,4,5,2,6};
    public static int k = 3;
    public static int[]dp;
    public static void main(String [] args){
        dp = new int[arr.length];
        Arrays.fill(dp,-1);
        System.out.println(calcPartition(0));
    }
    // k = 3
    // 1,3,4,5,2,6
    // 6
    public static int calcPartition(int i){
        if(i==arr.length)
            return 0;

        if(dp[i]!=-1)
            return dp[i];

        int index = i;
        int res = Integer.MAX_VALUE;
        int cur = 1;
        int sum = 0;
        while(cur <= k && i<arr.length){
            sum = Math.max(sum,arr[i]);
            res = Math.min(res,sum+calcPartition(i+1));
            cur++;
            i++;
        }
        dp[index] = res;
        return dp[index];
    }

}