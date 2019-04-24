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

// O(2n)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] productR = new int[nums.length];
        
        for (int j = nums.length - 1; j >= 0; j --){
            if (j == nums.length - 1){
                productR[j] = nums[j];
            } else{
                productR[j] = productR[j + 1] * nums[j];
            }
        }
        
        int[] result = new int[nums.length];
        int productL = 1;
        for (int i = 0; i < nums.length; i ++){
            if (i == 0){
                result[i] = productR[i + 1];
            } else if (i == nums.length - 1){
                result[i] = productL;
            } else {
                result[i] = productL * productR[i + 1];
            }
            
            productL = productL * nums[i];
        }
        
        return result;
    }
    
    // [1, 2, 3, 4]
    // [24, 12, 8 ,6 ]
    
}
