public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    
    public int[] subarraySumClosest(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length < 2){
            return result;
        }
        
        int sum = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] prefixSum = new int[nums.length];
        hm.put(0, -1);
        
        for (int i = 0; i < nums.length; i++){ // O(n)
            sum = sum + nums[i];
            prefixSum[i] = sum;
            if (hm.containsKey(sum)){
                result[0] = hm.get(sum) + 1 ;
                result[1] = i;
                return result;
            }
            hm.put(sum, i);
        }
        
        //[-3, -2, -1, -4, 1]
        //=> [-4, -3, -2, -1, 1]
        Arrays.sort(prefixSum); // O(log(n))
        int closest = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        for (int i = 0; i < prefixSum.length -1; i ++){ // O(n)
            if (Math.abs(prefixSum[i] - prefixSum[i + 1]) < closest){
                closest = Math.min(closest, Math.abs(prefixSum[i] - prefixSum[i + 1]));
                left = prefixSum[i];
                right = prefixSum[i + 1];
            }
        }
        
        if (hm.get(left) < hm.get(right)){
            result[0] = hm.get(left) + 1;
            result[1] = hm.get(right);
        } else {
            result[0] = hm.get(right) + 1;
            result[1] = hm.get(left);
        }
        
        return result;
        
    }
}
