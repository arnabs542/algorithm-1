//O(n^2)

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] == nums[i -1]){
                continue;
            }
            
            twoSum(nums, i, result);
        }
        
        return result;
    }
    
    private void twoSum(int[] nums, int index, List<List<Integer>> result){
        int start = index + 1;
        int end = nums.length - 1;
        int left = start;
        int right = end;
        int target = - nums[index];
        while (left < right){
            while (left < right && left > start && nums[left] == nums[left - 1]){
                left ++;
            }
            
            if (left < right && nums[left] + nums[right] == target){
                List<Integer> subset = new ArrayList<Integer>();
                subset.add(nums[left]);
                subset.add(nums[right]);
                subset.add(nums[index]);
                result.add(subset);
                left ++;
                right --;
            } else if (left < right && nums[left] + nums[right] > target){
                right --;
            } else {
                left ++;
            }
        }
    }
}
