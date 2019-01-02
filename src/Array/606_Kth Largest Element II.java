public class Solution {
    /**
     * @param nums: an integer unsorted array
     * @param k: an integer from 1 to n
     * @return: the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        return findkth(nums, k, 0, nums.length - 1);
    }
    
    private int findkth(int[] nums, int k, int start, int end){
        if (start == end){
            return nums[start];
        }
        int l = start;
        int r = end;
        int pivot = nums[(start + end)/2];
        
        while(l <= r){
            while(l <= r && nums[l] > pivot){
                l ++;
            }
            
            while(l <= r && nums[r] < pivot){
                r --;
            }
            
            if (l <= r){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l ++;
                r --;
            }
        }
        
        // |----------|--|-----------|
        // start      r  l           end
        if (start + k - 1 <= r){
            return findkth(nums, k, start, r);
        }
        
        if (start + k - 1 >= l){
            return findkth(nums, k - (l - start), l, end);
        }
        return nums[r + 1];
    }
}
