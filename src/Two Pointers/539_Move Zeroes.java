    public void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        //Arrays.sort(nums);
        
        for(left = 0; right < nums.length; right ++){
            if (nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left = left +1;
            }
        }
    }
