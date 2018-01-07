public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE; // find the lowest point to purchase
        int maxProfit = 0; // find the point with max profit to sell
        for (int i = 0; i < prices.length; i ++){
            min = prices[i] < min? prices[i]: min;
            maxProfit = prices[i] - min > maxProfit? prices[i] - min: maxProfit;
        }
        
        return maxProfit;
    }
}
