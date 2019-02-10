public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer denotes the middle number of the array
     */
    public int median(int[] nums) {
        int k = 0;

        if (nums.length % 2 == 0){
            quickSelect(0, nums.length - 1, nums, (nums.length / 2));
            return nums[(nums.length / 2) - 1];

        } else {
            quickSelect(0, nums.length - 1, nums, (nums.length / 2) + 1);
            return nums[(nums.length / 2)];
        }
        
        
    }
    
    private void quickSelect(int start, int end, int[] nums, int k){
        if (start >= end){
            return;
        }
        int l = start;
        int r = end;
        int pivot = nums[(start + end)/2];
        
        while (l <= r){
            while (l <= r && nums[l] < pivot){
                l ++;
            }
            
            while (l <= r && nums[r] > pivot){
                r --;
            }
            
            if (l <= r){
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l ++;
                r --;
            }
        }
        
        if (start + k - 1 <= r){
            quickSelect(start, r, nums, k);
        } else {
            quickSelect(l, end, nums, k - (l - start));
        }
    }
}
