## SubArrays

* 41 Maximum Subarray
* 44 Minimum Subarray
=> 道理同上

* 138 Subarray Sum 
``` java
// HashMap 在Array 题目中一般可以用O(n)的时间复杂度解决两种问题
// 1，求两者之和为固定某数
// 2，求两个index之间的所有数的和为某数
// => 開個hashmap<sum, put 預設值(0, -1) and 所有prefix sum
```

* 139 Subarray Sum Closest

## Median
=> find kth (還沒排序, quick select)

``` java 
// Quick Select
// T(n) = O(n) + O(n/2) + O(n/4) + O(n/8) .....
//     ~= O(n)
```
* 461 Kth Smallest Numbers in Unsorted Array 
* 606 Kth Largest Element II  
* 5 Kth Largest Element

---
=> find kth (已經排好序, 可以直接2分嘗試去掉不需要的答案)
* 65 Median of two Sorted Arrays </br>
Sol 1.) 兩個array 各自去找看看有沒有k/2個數 O(log(m + n)) </br>
Sol 2.) 2分答案 O(log(m + n)) </br>

* 931 Median of K Sorted Arrays 

Sol 1.) 2分答案 => O(log(range) * klogn)
```java
/* 
   k rows, each array has n element
   range = max - min
   O(log(range) * k(log(n)))
*/
```
Sol 2.) priority queue => O(nlogk)
``` java
/* k rows, total n element
   priority queue size: k
   priority queue offer: O(logk)
   priority queue poll: O(logk)
   => O(nlogk)
  */
```



