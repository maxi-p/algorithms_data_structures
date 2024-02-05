class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int l=0;
        int r=0;
        int max = Integer.MIN_VALUE;
        
        for(r=0; r<len; r++){
            if(prices[r]<prices[l]){
                l = r;
            }
            max = Math.max(max, prices[r] - prices[l]);
        }
        
        return max;
    }
}