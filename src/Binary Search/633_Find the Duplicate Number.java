public class Solution {
   
    /**
         * nums = [5, 5, 4, 3, 2, 1]  
         * nums contains n + 1 integers
         * <= 1 有1個數 (1)
         * <= 2 有2個數 (1, 2)
         * <= 3 有3個數 (1, 2, 3)
         * <= 4 有4個數
         * <= 5 有6個數 .... 重複! 
         * 2分array裡面有可能的數, 從1 到 nums.length -1
         * O(log(n) * n)
         **/
        
    public int findDuplicate(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        
        while(l + 1 < r){
            int mid = l + (r - l)/2;
            if (getSmallerOrEqualCount(nums, mid) <= mid){ // "<=" 因為nums裡面的數可能會跳號
                l = mid;
            } else {
                r = mid;
            }
        }
        
        if (getSmallerOrEqualCount(nums, l) <= l){
            return r;
        }
        
        return l;
    }
    
    private int getSmallerOrEqualCount(int[] nums, int target){
        int count = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] <= target){
                count ++;
            }
        }
        
        return count;
    }
}
