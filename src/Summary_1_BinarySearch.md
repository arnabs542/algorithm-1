# Binary Search O(logn)
find target value in sorted array/list

## Review
* 62 Search in Rotated Sorted Array

* 390 Find Peak Element II (2維 - 行列交替二分) O(n+m)

* Fast power

* 633 Find the Duplicate Number

* 586 Sqrt(x) II

* 617 Maximum Average Subarray II (to-do)

* 460 Find K Closest Elements


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
## Find K Closest Elements
460. Find K Closest Elements

找到start and end, 之後loop k次, 看看start, end哪個靠近放哪個
```java
for (int i = 0; i < k; i ++){
            if (start < 0){
                // go to right
                result[i] = A[end];
                end ++;
                continue;
            }
            if (end > A.length - 1){
                // go to left
                result[i] = A[start];
                start --;
                continue;
            } 
            if ((Math.abs(A[start] - target) <= Math.abs(A[end] - target))){
               result[i] = A[start];
               start --;
            } else {
                result[i] = A[end];
                end ++;
            }
        }
 ```

## Rotated Sorted Array
跟最後一個數比, 比最後一個數大的是在rotated sorted array的前段, 比最後一個數小的是在rotated sorted array的後段, 最後判斷start/end哪個大
 
159. Find Minimum in Rotated Sorted Array
 
62. Search in Rotated Sorted Array

## Find Peak Element
75. Find Peak Element (1維)

390. Find Peak Element II (2維 - 行列交替二分) O(n+m)

## 倍增法 Exponential Backoff
447. Search in a Big Sorted Array O(log k)
 
用乘以2來預估start and end 開始的值
 ``` java 
     int index = 1;
     while(reader.get(index -1) < target){
        index = index * 2;
     }
     int start = 0;
     int end = index -1;
 ```
## Fast power
140. Fast Power

(ac)%b = (a%b)(c%b)%b
指數項/2, 討論餘數 = 1, or 餘數 = 0

428. Pow(x, n)

n could be >=0 or < 0;

141. Sqrt(x)
``` java
/* 二分答案! 
   先取 mid, 估計mid ^ 2 < or > x
*/
```
586. Sqrt(x) II
``` java
/* 二分答案! 
   題目要求return double, 需要考慮 x < 1 的情況, x < 1 的話令x = 1
   end = Math.max(1, x);
   esp = 1e-10;(精確度)
*/
```
183. Wood Cut

437. Copy Books

＊ 633 Find the Duplicate Number

