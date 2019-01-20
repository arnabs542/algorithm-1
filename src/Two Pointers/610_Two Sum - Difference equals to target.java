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


public class Solution {
    /**
     * @param nums: an array of Integer
     * @param target: an integer
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum7(int[] nums, int target) {
        Map<Integer, Integer> hm = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i ++){
            int diff1 = nums[i] + target;
            int diff2 = nums[i] - target;
            if (hm.containsKey(nums[i])){
                result[0] = hm.get(nums[i]) + 1;
                result[1] = i + 1;
            }  else {
                hm.put(diff1, i);
                hm.put(diff2, i);
            }
        }
        
        return result;
    }
}

