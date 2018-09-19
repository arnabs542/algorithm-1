public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        for (int i = 0; i < nums.length; i ++){
            if (hm.get(nums[i] + target) != null){
                return new int[]{hm.get(nums[i] + target) + 1, i + 1};
            } else if (hm.get(nums[i] - target) != null){
                return new int[]{hm.get(nums[i] - target) + 1, i + 1};
            } else {
                hm.put(nums[i], i);
            }
        }
        
        return null;
    }
}
