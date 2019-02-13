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

## Best time to buy and sell stock
* 150 Best Time to Buy and Sell Stock II
* 1000 Best Time to Buy and Sell Stock with Transaction Fee

## Median
### data not sorted
=> find kth (還沒排序, quick select)

``` java 
// Quick Select
// T(n) = O(n) + O(n/2) + O(n/4) + O(n/8) .....
//     ~= O(n)
// 用O(n/2) O(n/4) O(n/8) .... 的時間進行交換
```
* 461 Kth Smallest Numbers in Unsorted Array 
* 606 Kth Largest Element II  
* 5 Kth Largest Element
* 80 Median

---
### data sorted

=> find kth (已經排好序, 可以直接嘗試去掉不需要的答案)
* 65 Median of two Sorted Arrays </br>
Sol 1.)  O(log(m + n))
``` java
   要找從小到大, 第k小的數
   兩個array 各自去找前k/2大的數;
   找到後比大小, 把小的前k/2個數丟掉
   繼續找 k - k/2個數
   直到
   => 如果array A 已經沒有數, 直接從array B 取第k個
   => 如果array B 已經沒有數, 直接從array A 取第k個
   => 如果只要取一個, 取比較小的那個
   只要O(1)的時間, 數據規模變成log(m + n)
```
Sol 2.) 2分答案 O(log(range) * (log(m) + log(n))) </br>

* 931 Median of K Sorted Arrays 
=> 注意最後return double ((double)med1 + (double)med2) / 2

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
=> maintain priority queue
* 81 Find Median from Data Stream

