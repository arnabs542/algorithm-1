    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        //Arrays.sort(nums);
        
        for(left = 0; right < nums.length; right ++){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left = left +1;
            }
        }
    }


public class Solution {
    // 把非0的都移到左邊, 剩下補0
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0){
            return;
        }
        int index0 = 0;
        
        for (int j = 0; j < nums.length; j ++){
            if (nums[j] != 0){
                nums[index0] = nums[j];
                index0 ++;
            }
        }
        
        for (int i = index0; i < nums.length; i ++){
            nums[i] = 0;
        }
    }
}
