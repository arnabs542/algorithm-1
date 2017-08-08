public class Solution {
    /**
     * @param nums an array of integers
     * @return the number of unique integers
     */
    public int deduplication(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        
        int result = 0;
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()){
            nums[result++] = entry.getKey();
        }
        
        return result;
    }
}
