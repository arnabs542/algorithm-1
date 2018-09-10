# Binary Search O(logn)
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
            int mid = start + (end - start) / 2;
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
## First position
14. First Position of Target
從右邊逼過去找first position: nums[mid] == target 時讓 end = mid; 最後先討論 nums[start]
```java
        if (nums[mid] == target){
                end = mid;
            } else if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
           
       
```

## Last position
458. Last Position of Target
從左邊逼過去找last position: nums[mid] == target 讓 start = mid; 最後先討論 nums[end]
```java
        if (nums[mid] == target){
                start = mid;
            } else if (nums[mid] > target){
                end = mid;
            } else {
                start = mid;
            }
           
       
```


