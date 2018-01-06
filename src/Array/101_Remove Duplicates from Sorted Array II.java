public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int size = 1;
        int number = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++){
            if (nums[i] == number){
                if (count < 2){
                    nums[size++] = nums[i];
                    count ++;
                }
            }else{
                number = nums[i];
                count = 1;
                nums[size ++] = nums[i];
            }
        }
        
        return size;
    }
}
