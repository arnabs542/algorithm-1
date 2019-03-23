# Binary Tree
## Review
* #93, #95, #88 #900, #901, #246, #902, #246

## Traverse
### Level Order(BFS)
### Pre Order 
* 根左右
* 66 Binary Tree Preorder Traversal
### In Order 
* 左根右
* 67 Binary Tree Inorder Traversal
### Post Order
* 左右根
* 68 Binary Tree PostOrder Traversal

## 求(depth, sum, path, lowest common anccestor)
===> 深度
* 596 Minimum Subtree 
* 97 Maximum Depth of Binary Tree 
* 155 Minimum Depth of Binary Tree 
* 93 Balanced Binary Tree 

===> LCA
* 88 Lowest Common Ancestor of a Binary Tree
* 578 Lowest Common Ancestor III </br>
 => 左右都存在為LCA </br>
 => 回傳result 以判斷 </br>
 => 因為要找Lowest common ancestor (A, B的第一個共同祖先) </br>
 => only (LCA == null) 才算是答案
* 474 Lowest Common Ancestor II - 題目提供parent tree node

===> path
* 480 Binary Tree Paths

===> path Sum
* 376 Binary Tree Path Sum
* 246 Binary Tree Path Sum II
* 472 Binary Tree Path Sum III (skip)
* 863 Binary Tree Path Sum IV (skip)

===> 改變結構
* 453 Flatten Binary Tree to Linked List </br>
=> 紀錄最後一個點, 才能把right的部分接進來


## Binary Search Tree
=> left subtree contains only nodes smaller than root's key </br>
=> right subtree contains only nodes greater than root's key </br>
=> left subtree and right subtree are also binary search tree </br>
=> 利用特性取值

* 902 Kth Smallest Element in a BST</br>
 => inorder traverse 先找到最小的 O(n) </br>
 => 計算經過的k 的個樹, 找到第k小的 O(k)</br>
 => O(n + k) </br>
 => To-Do: O(h + k)</br>
 
 
 
* 95 Validate Binary Search Tree
 => recursion 傳入 lowerbound and upperbound
 
* 900 Closest Binary Search Tree Value

* 915 Inorder Predecessor in BST
* 448 Inorder Successor in BST

* 701 Trim a Binary Search Tree </br>
=> 判斷root是否在區間內, </br>
=> 在區間內, root.left, root.right各自下去 </br>
=> 不再區間內, 判斷要trim left or right </br>
=> trim left => root = 遞歸root.right </br>
=> trim right => root = 遞歸root.left </br>

* 11 Search Range in Binary Search Tree

