// brute force way
// generate all partitioned subarray
import java.util.Arrays;
// import java.util.Integer;

public class Solution{
    public static int [][]dp;
    public static int limit;
    public static int len;
    public static int [] copy;
    public static int min = Integer.MAX_VALUE;

    public static void main(String [] args){
        int [] arr = {1,3,4,5,2,6};
        System.out.println(calculateCost(arr, 4));
    }

    public static int calculateCost(int arr[], int threshold){
        copy = arr;
        len = arr.length;
        dp = new int [len][len];
        for(int i=0; i<len; i++){
                Arrays.fill(dp[i],-1);
        }
        limit = threshold;
        return 0;
    }
    
    public int dp(int i, int j){
        if(j > len-1){
            j = len-1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(i == j){
            return copy[i];
        }
        
        int cost = 0;
        int part = i;
        int localLen = j-i+1;
        //TODO: 
        for(int i = limit; i > 0; i--){
            
        }
        
        int cur;
    }

}