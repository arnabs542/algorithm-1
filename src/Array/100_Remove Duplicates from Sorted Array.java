public class Solution {
    /*
     * @param nums: An ineger array
     * @return: An integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int size = 1;
        
        for (int i = 1; i < nums.length; i++){
            if (nums[i] != nums[i-1]){
                nums[size++] = nums[i]; 
            }
        }
        
        return size;
    }
}
