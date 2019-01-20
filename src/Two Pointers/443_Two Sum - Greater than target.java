public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){
            if(nums[i] + nums[j] > target){
                count = count + j - i;
                // i ~ j 之間的每個加上nums[j]都會> target
                j --;
            } else {
                i ++;
            }
        }
        
        return count;
    }
}
