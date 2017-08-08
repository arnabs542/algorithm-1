class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }
        
        int left = 0; 
        int right = nums.length - 1;
        int count = 0;
        while (count <= right){
            if (nums[count] == 0){
                // swap to left
                swap(nums, left, count);
                left ++;
                count ++; 
            }else if (nums[count] == 1){
                count ++; 
            }else if (nums[count] == 2){
                // swap to right
                swap(nums, right, count);
                right --;
                
                // count doesn't move if swap to right
                // count ++; 
            }
        }
    }
    
    private void swap(int[] nums, int target, int currentCount){
        int temp = nums[target];
        nums[target] = nums[currentCount];
        nums[currentCount] = temp;
    }
}
