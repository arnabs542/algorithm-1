public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
     public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        
        //int[] nums = removeDuplicates(candidates);
        
        Arrays.sort(candidates);
        dfs(candidates, target, new ArrayList<Integer>(), result, target, 0);
        
        return result;
    }
    
   
    
     private void dfs(
        int[] nums 
        , int target
        , List<Integer> temp 
        , List<List<Integer>> result
        , int remaining
        , int startIndex
      ){
    
        if (remaining == 0){
        	result.add(new ArrayList<Integer>(temp));
          	return;
    }
    
    for (int i = startIndex; i < nums.length; i ++){
    
      if (nums[i] > remaining){
        break;
      }
      
      temp.add(nums[i]);
      dfs(nums, target, temp, result, remaining - nums[i], i);
      temp.remove(temp.size()-1);
    }
}   
}
