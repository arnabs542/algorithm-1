public class Solution {
    /*
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null || num.length == 0) {
            return result;
        }
        
        Arrays.sort(num);
        int[] candidates = removeDuplicates(num);

        dfs(candidates, target, new ArrayList<Integer>(), result, target, 0);
        
        return result;    
        
    }
    
    private int[] removeDuplicates(int[] num){
        
        int index = 0;
        for (int i = 0; i < num.length -1; i++){
            if (num[i] != num[i+1]){
                num[index] = num[i];
                index++;
            }
        }
        
        int[] candidates = new int[index];
        for (int j = 0; j < index; j ++){
            candidates[j] = num[j];
        }
        
        return candidates;
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
        dfs(nums, target, temp, result, remaining - nums[i], i+1);
        temp.remove(temp.size()-1);
            
        }
    } 
}
