public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    // given nums = [-3,1,1,-3,3]
    public List<Integer> subarraySum(int[] nums) {
        //-3, 0
        //-2, 1
        //-1, 2
        //-4, 3
        //-1, 4 
        // sum 回到一樣的數字, 表示中間那段白加了, sum = 0
        List<Integer> result = new ArrayList<Integer>();
        if (nums == null || nums.length == 0){
            return null;
        }
        
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        for (int i = 0; i < nums.length; i ++){
            sum = sum + nums[i];
            if (hm.containsKey(sum)){
                result.add(hm.get(sum) + 1);
                result.add(i);
                return result;
            }
            
            hm.put(sum, i);
        }
        
        return null;
    }
}
