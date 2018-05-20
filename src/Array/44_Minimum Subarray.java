public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        int minSubArray = Integer.MAX_VALUE;
        int maxPrefix = 0;
        int sum = 0;
        for (int i = 0; i < nums.size(); i ++){
            sum = sum + nums.get(i);
            minSubArray  = Math.min(minSubArray, sum - maxPrefix);
            maxPrefix = Math.max(maxPrefix, sum);
        }
        
        return minSubArray;
    }
}
