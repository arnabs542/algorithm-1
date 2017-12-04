class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        
        if (nums == null || nums.length == 0){
            result.add(temp);
            return result;
        }
        
        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);
        Arrays.sort(nums);
        helper(nums, result, temp, visited);
        
        return result;
    }
    
    
    private void helper(
        int[] nums
        , List<List<Integer>> result
        , List<Integer> temp
        , boolean[] visited){
            
            if (temp.size() == nums.length){
                if (!result.contains(new ArrayList(temp))){
                    result.add(new ArrayList<Integer>(temp));
                }
                return; 
            }
            
            for (int i = 0; i < nums.length; i ++){
                if(visited[i] == true)   {
                    continue;
                }
                
                visited[i] = true;
                temp.add(nums[i]);
                helper(nums, result, temp, visited);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
    }
    
   
}


