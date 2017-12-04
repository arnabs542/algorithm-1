class Solution {
    /**
     * @param S: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0){
            result.add(new ArrayList<Integer>(temp));
            return result;
        }
        
        int startIndex = 0;
        Arrays.sort(nums);
        helper(startIndex, nums, temp, result);
        
        return result;
    }
    
    private void helper(
        int startIndex
        , int[] nums
        , List<Integer> temp
        , List<List<Integer>> result
        ){
            result.add(new ArrayList<Integer>(temp));
            for (int i = startIndex; i < nums.length; i++){
                
                
                temp.add(nums[i]);
                helper(i+1, nums, temp, result);
                temp.remove(temp.size()-1);
            }
    }
}
