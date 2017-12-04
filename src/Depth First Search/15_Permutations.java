class Solution {
    /**
     * @param nums: A list of integers.
     * @return: A list of permutations.
     */
   public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result = new ArrayList<>();
       List<Integer> temp = new ArrayList<Integer>();

        if (nums == null || nums.length == 0){
            result.add(new ArrayList(temp));
            return result;
        }
        
        helper(nums, temp, result);
        
        return result;
    }
    
    private void helper(
        int[] nums
        , List<Integer> temp
        , List<List<Integer>> result){
            
            if (temp.size() == nums.length){
                result.add(new ArrayList<Integer>(temp));
                return;
            }
            
            for (int i = 0; i < nums.length; i ++){
                if(temp.contains(nums[i])){
                    continue;
                }
                
                temp.add(nums[i]);
                helper(nums, temp, result);
                temp.remove(temp.size() -1);
            }
        
    }
    
    
}
