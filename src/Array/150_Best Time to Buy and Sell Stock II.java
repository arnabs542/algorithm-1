public class Solution {
    /*
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        if (prices == null || prices.length == 0){
            return profit;
        }
        for (int i = 0; i < prices.length - 1; i++){
            if (prices[i+1] - prices[i] > 0){
                profit = profit + prices[i+1] - prices[i];
            }
        }
        
        return profit;
    }
}
