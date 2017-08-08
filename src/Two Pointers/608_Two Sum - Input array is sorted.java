public class Solution {
    /*
     * @param nums an array of Integer
     * @param target = nums[index1] + nums[index2]
     * @return [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2){
            return null;
        }
        int i = 0;
        int j = nums.length - 1;
        while( i < j){
            if (nums[i] + nums[j] == target){
                return new int[]{i+1, j+1};
            } else if (nums[i] + nums[j] > target){
                j--;
            } else {
                i++;
            } 
        }
        
        return null;
        
    }
}
