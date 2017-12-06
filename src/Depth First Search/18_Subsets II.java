class Solution {
     public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         List<Integer> temp = new ArrayList<Integer>();
         
         if (nums == null || nums.length == 0){
             result.add(new ArrayList<Integer>(temp));
             return result;
         }
         
         Arrays.sort(nums);
         
         helper(nums, 0, result, temp);
         
         return result;
    }
    
    private void helper(
        int[] nums
        , int startIndex
        , List<List<Integer>> result
        , List<Integer> temp){
            
            result.add(new ArrayList<Integer>(temp));
            for (int i = startIndex; i < nums.length; i++){
                
                if (i != startIndex && nums[i] == nums[i-1]){
                    continue;
                }
                temp.add(nums[i]);
                helper(nums, i+1, result, temp);
                temp.remove(temp.size()-1);
                
            }
        
    }
}
