public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (n == 0){
            return result;
        }
        
        int[] nums = new int[n];
        for (int i = 0; i < n; i ++){
            nums[i] = i + 1;
        }
        
        dfs(nums, 0, k, new ArrayList<Integer>(), result);
        return result;
    }
    
    private void dfs(
        int[] nums
        , int startIndex
        , int subsetCount
        , List<Integer> subset
        , List<List<Integer>> result){
        
        if (subset.size() == subsetCount){
            result.add(new ArrayList<Integer>(subset));
        }
        
        for (int i = startIndex; i < nums.length; i ++){
            subset.add(nums[i]);
            dfs(nums, i + 1, subsetCount, subset, result);
            subset.remove(subset.size()-1);
        }
    }
}
