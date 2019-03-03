public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // 1. sort 
        // 2. DFS(int startIndex)
        Arrays.sort(num);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        DFS(0, num, subset, result, target);
        
        return result;
    }
    
    private void DFS(int startIndex, 
                    int[] num,
                    List<Integer> subset,
                    List<List<Integer>> result, 
                    int target){
                         
        if (target == 0){
            result.add(new ArrayList<Integer>(subset));
            return;
        }
        
        for (int i = startIndex; i < num.length; i ++){
            if (num[i] > target){
                return;
            }
            
            if (i > startIndex && num[i] == num[i - 1]){
                continue;
            }
            
            subset.add(num[i]);
            DFS(i + 1, num, subset, result, target - num[i]);
            subset.remove(subset.size() - 1);
        }
    }
}
