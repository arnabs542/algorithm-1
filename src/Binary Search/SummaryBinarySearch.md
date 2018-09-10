# Binary Search
find target value in sorted array/list

## Basic template
457. Classical Binary Search
```java
public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0){
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while(start + 1 < end){
            int mid = (start + end) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if(nums[start] == target){
            return start;
        }
        
        if(nums[end] == target){
            return end;
        }
        
        return -1;
    }
```

