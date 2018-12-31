41. Maximum Subarray
=> int maxSubarray, minPrefix
=> loop through the array
=> maxSubarray = sum - minPrefix

44. Minimum Subarray
=> 道理同上

138. Subarray Sum 
HashMap 在Array 题目中一般可以用O(n)的时间复杂度解决两种问题
1，求两者之和为固定某数
2，求两个index之间的所有数的和为某数

=> 開個hashmap<sum, put 預設值(0, -1) and 所有prefix sum
