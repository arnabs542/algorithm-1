public class Solution {
    /**
     * @param coins: a list of integer
     * @param amount: a total amount of money amount
     * @return: the fewest number of coins that you need to make up
     */
    public int coinChange(int[] coins, int amount) {
        int[] numOfCoins = new int[amount + 1]; 

        numOfCoins[0] = 0;
        for (int i = 1; i < amount + 1; i ++){
            numOfCoins[i] = -1;
            int minNumOfCoins = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j ++){
                // amount < coins to use => continue
                if (i - coins[j] < 0){
                    continue;
                }
                
                // 用了這個coin, 之前的那個數是湊不出來的 => continue
                if (numOfCoins[i - coins[j]] == -1){
                    continue;
                }
                
                minNumOfCoins = Math.min(minNumOfCoins, numOfCoins[i - coins[j]] + 1);
            }
            
            if (minNumOfCoins != Integer.MAX_VALUE){
                numOfCoins[i] = minNumOfCoins;
            }
        }
        
        return numOfCoins[amount];
    }
}
