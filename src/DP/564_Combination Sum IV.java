public class Solution {
    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // DFS 超時
        // DP
        int[] list = new int[target + 1]; // combination ways to get for 1 to target
        list[0] = 1;
        
        for (int i = 1; i <= target; i ++){
            list[i] = 0;
            int numberOfWays = 0;
            for (int j = 0; j < nums.length; j ++){
                if (nums[j] > i){ // bigger than the number to combine
                    continue;
                }
                
                if (list[i - nums[j]] == 0){ 
                    continue;
                }
                
                numberOfWays = numberOfWays + list[i - nums[j]];
            }
            
            list[i] = numberOfWays;
        }
        
        return list[target];
    }
}
