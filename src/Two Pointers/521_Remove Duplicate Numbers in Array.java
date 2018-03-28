
// Time: O(n); Space: O(n)
public class Solution {
    public int deduplication(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>();
        for (int i = 0; i < nums.length; i++){
            map.put(nums[i], true);
        }
        
        int result = 0;
        for (Map.Entry<Integer, Boolean> entry: map.entrySet()){
            nums[result++] = entry.getKey();
        }
        
        return result;
    }
}

// Time: O(nlogn); O(1) extra space
public class Solution {
    /*
     * @param nums: an array of integers
     * @return: the number of unique integers
     */
    public int deduplication(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        Arrays.sort(nums);
        // 1, 1, 2, 3, 4, 4
        int j = 0;
        for (int i = 0; i < nums.length; i ++){
            if (i > 0 && nums[i] != nums[j]){
                j ++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
