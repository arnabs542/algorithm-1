// Time: O(nlogn)

class Solution {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; i ++){
            Integer ceiling = ts.ceiling(nums[i]);
            if (ceiling != null){
                ts.remove(ceiling);
            }
            
            ts.add(nums[i]);
        }
        
        return ts.size();
    }
}
