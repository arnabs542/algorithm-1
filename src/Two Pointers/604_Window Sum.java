public int[] winSum(int[] nums, int k) {
        if (nums == null || nums.length == 0 ){
            return new int[0];
        }
        
        int[] result = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length - k + 1; i ++){
            int temp = 0;
            for(int j = 0; j < k; j++){
                temp = temp + nums[i+j]; 
            }
            
            result[i] = temp;
        }
        
        return result;
    }
