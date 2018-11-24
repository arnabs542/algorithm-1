# Binary Tree
## Review
* #93, #900

## Level Order(BFS)
## Pre Order 
根左右</br>
66. Binary Tree Preorder Traversal

## In Order
左根右</br>
67. Binary Tree Inorder Traversal

## Post Order
左右根</br>
68. Binary Tree PostOrder Traversal

## Depth
* 97 Maximum Depth of Binary Tree 
* 155 Minimum Depth of Binary Tree 
* 93 Balanced Binary Tree 
 => 求深度
* 596 Minimum Subtree
* 453 Flatten Binary Tree to Linked List </br>
 => 紀錄最後一個點, 才能把right的部分接進來
* 578 Lowest Common Ancestor III </br>
 => 左右都存在為LCA </br>
 => 回傳result 以判斷 </br>
 => 因為要找Lowest common ancestor (A, B的第一個共同祖先) </br>
 => only (LCA == null) 才算是答案
 
## Binary Search Tree
=> left subtree contains only nodes smaller than root's key </br>
=> right subtree contains only nodes greater than root's key </br>
=> left subtree and right subtree are also binary search tree </br>
=> inorder, preporder

* 95 Validate Binary Search Tree
 => recursion 傳入 lowerbound and upperbound
 
* 900 Closest Binary Search Tree Value
* 902 Kth Smallest Element in a BST
 => inorder traverse 先找到最小的 O(h) 樹高
 => 計算經過的k 的個樹, 找到第k小的 O(k)
 => O(h+k)

* 915 Inorder Predecessor in BST

* 701 Trim a Binary Search Tree
=> 判斷root是否在區間內,
=> 在區間內, root.left, root.right各自下去
=> 不再區間內, 判斷要trim left or right
=> trim left => root = 遞歸root.right
=> trim right => root = 遞歸root.left

// DFS
// 480. Binary Tree Paths
// BinaryTreePathSum

