public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end){
            int mid = (start + end)/2;
            // 跟最後一位比, 以對付corner case like [1,2,3]
            if (nums[mid] >= nums[nums.length - 1]){
                // 在左半
                start = mid;
            }else{
                // 在右半
                end = mid;
            }
        }
        
        if (nums[start] < nums[end]){
            return nums[start];
        }else{
            return nums[end];
        }
    }
}
