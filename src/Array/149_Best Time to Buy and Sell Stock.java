public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int maxProfitValue = Integer.MIN_VALUE;
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i ++){
            minCost = Math.min(minCost, prices[i]);
            maxProfitValue = Math.max(maxProfitValue, prices[i] - minCost);
        }
        
        return maxProfitValue;
    }
}
