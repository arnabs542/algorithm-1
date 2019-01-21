## SubArrays

* 41 Maximum Subarray </br>
=> max sum - min pre-sum = maxSubArray

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
* 149 Best Time to Buy and Sell Stock
* 943 Range Sum Query - Immutable

## SubArrays => SubMetrix (to-do)
* 405 Submatrix Sum
https://www.lintcode.com/problem/submatrix-sum/description

* 944 Maximum Submatrix


## Median
### data not sorted
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
### data sorted

=> find kth (已經排好序, 可以直接嘗試去掉不需要的答案)
* 65 Median of two Sorted Arrays </br>
Sol 1.)  O(log(m + n))
``` java
   要找第k大的數
   兩個array 各自去找前k/2大的數;
   找到後比大小, 把小的前k/2個數丟掉
   繼續找 k - k/2個數
```
Sol 2.) 2分答案 O(log(range) * (log(m) + log(n))) </br>

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

### from data stream
* 81 Find Median from Data Stream


## Best time to buy and sell stock
* 150 Best Time to Buy and Sell Stock II
* 1000 Best Time to Buy and Sell Stock with Transaction Fee





