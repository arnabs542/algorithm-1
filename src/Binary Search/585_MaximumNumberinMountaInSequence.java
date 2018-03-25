package binarySearch;

public class Solution {
    /**
     * @param nums a mountain sequence which increase firstly and then decrease
     * @return then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }

        int start = 0;
        int end = nums.length -1;

        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if (nums[mid + 1] - nums[mid] >= 0){
                start = mid;
            }else{
                end = mid;
            }
        }

        if (nums[end] > nums[start]){
            return nums[end];
        }else{
            return nums[start];
        }

    }
}


public class Solution {
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    public int mountainSequence(int[] nums) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        
        int start = 0;
        int end = nums.length -1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            if (mid - 1 >= 0){
                if (nums[mid] >= nums[mid - 1]){
                    start = mid;
                }else{
                    end = mid;
                }
            } else{
                start = mid;
            }
        }
        
        if (nums[start] > nums[end]){
            return nums[start];
        }
        
        return nums[end];
    }
}
