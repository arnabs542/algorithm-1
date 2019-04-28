class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i ++){
            int start = i + 1;
            int end = nums.length - 1;
            
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];

                if (Math.abs(closestSum - target) > Math.abs(sum - target)){
                    closestSum = sum;
                }
                if (sum < target){
                    start ++;
                } else {
                    end --;
                }
            }
        }
        
        return closestSum;
    }
}
