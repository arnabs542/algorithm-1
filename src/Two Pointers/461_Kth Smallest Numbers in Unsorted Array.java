public class Solution {
    /**
     * @param k: An integer
     * @param nums: An integer array
     * @return: kth smallest element
     */
    public int kthSmallest(int k, int[] nums) {
       return sort(nums, 0, nums.length -1, k);
    }
    
    private int sort(int[] nums, int start, int end, int k){
        if (start == end){
            return nums[start];
        }
        
        int pivot = nums[start + (end - start)/2];
        int left = start;
        int right = end;
        
        while(left <= right){
            while(left <= right &&  nums[left] < pivot){
                left ++;
            }
            
            while(left <= right &&  nums[right] > pivot){
                right --;
            }
            
            if (left <= right){
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left ++;
                right --;
            }
        }
        
        // |----------|---|------------|
        // start      r   l            end
        // have to check where k is in these 3 conditions
        if (start + k - 1 <= right){
            return sort(nums, start, right, k);
        }
        
        if (start + k - 1  >= left){
            return sort(nums, left, end, k - (left - start));
        }
        
        return nums[right + 1];
            
    }
}
