public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSubArray = Integer.MIN_VALUE;

        //**** 注意 minPreSum 預設為 0 *****
        int minPreSum = 0;
        for (int i = 0; i < nums.length; i ++){
            sum = sum + nums[i];
            
            //**** 注意: 先算maxSubArray ***** (test case: Input: [-1])
            maxSubArray = Math.max(maxSubArray, sum - minPreSum);
            //**** 注意: 再算minPreSum *****
            minPreSum = Math.min(sum, minPreSum);
        }
        
        return maxSubArray;
    }
}
