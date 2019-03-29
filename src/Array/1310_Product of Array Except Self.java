public class Solution {
    /**
     * @param nums: an array of integers
     * @return: the product of all the elements of nums except nums[i].
     */
    //O(2n)
    public int[] productExceptSelf(int[] nums) {
        int[] productFromL = new int[nums.length];
        productFromL[0] = 1;
        int[] productFromR = new int[nums.length];
        productFromR[nums.length - 1] = 1;
        
        for (int i = 1; i < nums.length; i ++){
            productFromL[i] = productFromL[i - 1] * nums[i - 1];
            productFromR[nums.length - 1 - i] = productFromR[nums.length - i] * nums[nums.length - i];
        }
        
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i ++){
            result[i] = productFromL[i] * productFromR[i];
        }
        
        return result;
    }
}
