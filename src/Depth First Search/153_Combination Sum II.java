public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (num == null){
            return result;
        }
        
        Arrays.sort(num);
        dfs(num, target, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    //1, 1, 2, 5, 6, 7, 10
    
    private void dfs(int[] nums
                , int target
                , int startIndex
                , List<Integer> subset
                , List<List<Integer>> result
        ){
            if (target == 0){
                result.add(new ArrayList<Integer>(subset));
                System.out.println("resut add: " + subset);
                return;
            }
            
            for (int i = startIndex; i < nums.length; i ++){
                if (i != 0 && i != startIndex && nums[i] == nums[i - 1]){
                    continue;
                }
                if (nums[i] > target){
                    break;
                }
                subset.add(nums[i]);
                dfs(nums, target - nums[i], i + 1, subset, result);
                subset.remove(subset.size() - 1);
            }
        
    }
}
