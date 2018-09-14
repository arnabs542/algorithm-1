public class Solution {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: an integer
     */
    public int twoSum2(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            if (nums[left] + nums[right] <= target){
                left ++;
            } else {
                count = count + right - left;
                right --;
            }
        }
        
        return count;
    }
}
