class NumArray {

    private int[] preSum;
    public NumArray(int[] nums) {
        preSum = new int[nums.length + 1];
        int sum = 0;
        preSum[0] = 0;
        for (int k = 0; k < nums.length; k ++){
            sum = sum + nums[k];
            preSum[k + 1] = sum;
        }
    }
    
    public int sumRange(int i, int j) {
        
        return (preSum[j + 1] - preSum[i]);
        
        
    }
}
