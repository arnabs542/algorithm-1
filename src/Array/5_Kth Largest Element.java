class Solution {
    /*
     * @param k : description of k
     * @param nums : array of nums
     * @return: description of return
     */
    public int kthLargestElement(int k, int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        return sort(nums, k, 0, nums.length-1);
    }
    
    
    private int sort(int[] nums, int k, int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[(start + end)/2];
        
        while(left <= right){
            // greater nums are in left;
            while(left <= right && nums[left] > pivot){
                left ++;
            }
            
            while(left <= right && nums[right] < pivot){
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
        
        if (start + k - 1 <= right){
            return sort(nums, k, start, right);
            
        }else if (start + k - 1 >= left){
            // change K to the Kth in right hand side
            return sort(nums, k- (left - start), left, end);
            
        }
        
        return nums[right + 1];

    }

    
};
