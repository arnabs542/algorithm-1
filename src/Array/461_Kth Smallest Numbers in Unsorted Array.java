public class Solution {
    /*
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
        if (nums == null || nums.length < k){
            return 0;
        }
        
        return quickSort(nums, 0, nums.length -1, k);
        
    }
    
    private int quickSort(int[] nums, int start, int end, int k){
        if (start >= end){
            return nums[start];
        }
        
        int pivot = nums[(start + end)/2];
        int left = start;
        int right = end;
        
        while (left <= right){
            while (left <= right && nums[left] < pivot){
                left ++;
            }
            
            while (left <= right && nums[right] > pivot){
                right --;
            }
            
            if (left <= right){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left ++;
                right --;
            }
        }
        
        if (start + k -1 <= right ){
            return quickSort(nums, start, right, k);
            
        } else if (start + k -1 >= left ){
            return quickSort(nums, left, end, k - (left - start));
        } 
        
        return nums[right + 1];
        
    }
}
