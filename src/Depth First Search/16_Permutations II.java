public class Solution {
    /*
     * @param :  A list of integers
     * @return: A list of unique permutations
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null){
            return result;
        }
        
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums); 
        
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        permutationHelper(nums, result, subset, visited);
        
        return result;
        
    }
    
    private void permutationHelper(int[] nums
                                    , List<List<Integer>> result
                                    , List<Integer> subset
                                    , boolean[] visited){
        if (subset.size() == nums.length){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for (int i = 0; i < nums.length; i ++){
            if (visited[i]){
                continue;
            }
            
            // 跟前面一樣 而且 前面還沒被放入的 => 排除
            if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1] == false){
                continue;
            }
            
            subset.add(nums[i]);
            visited[i] = true;
            permutationHelper(nums, result, subset, visited);
            subset.remove(subset.size() - 1);
            visited[i] = false;
        }
    }
};
