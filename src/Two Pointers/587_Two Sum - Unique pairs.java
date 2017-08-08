public class Solution {
    /**
     * @param nums an array of integer
     * @param target an integer
     * @return an integer
     */
    public int twoSum6(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return 0;
        }
        
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left < right){
            if (nums[left] + nums[right] == target){
                count ++;
                right --;
                left ++;
                while(left < right && nums[left] == nums[left - 1]){
                    left ++;
                }
                while(left < right && nums[right] == nums[right + 1]){
                    right --;
                }
            }else if (nums[left] + nums[right] < target){
                left ++;
            }else{
                right --;
            }
        }
        
        return count;
    }
}
