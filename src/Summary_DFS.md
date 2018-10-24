# DFS 
## Review
136. Palindrome Partitioning </br>

## DFS on Tree - inorder travesal

```java
public void inoder(TreeNode root, List<Integer> result){
  if (root == null){
    return;
  }
  
  inorder(root.left, result);
  result.add(root);
  inorder(root.right, result);
}
```
## DFS - combination
組合: 選過不用再選 (need start index)

``` java
public void DFS(List<String> result,
                List<String> subset,
                char[] chars,
                int startIndex
                ){
    // 終止條件 1 or 2 or 3
    // 1. 全部組合 不限答案長度
    result.add(new ArrayList<String>(subset));
    
    // or 2. if startIndex 到了備選答案的最後
    if (startIndex == chars.length){
      result.add(new ArrayList<String>(subset));
      return;
    }
    
    // or 3. 如果要找k個數中找n個組合, 終止條件: subset.size（） == n
    if (subset.size() == n){
      result.add(new ArrayList<String>(subset));
      return;
    }
    
    for (int i = startIndex; i < chars.length; i ++){
      subset.add(chars[i]);
      DFS(result, subset, chars, i + 1);
      subeset.remove(subset.size()-1);
      }
}

```
==== compare following together:
* 17 Subsets

* 135 Combination Sum </br>
=> 可重複使用candidates, 且candidates有重複 </br>
=> recursion (i) instead of (i + 1) </br>

* 153 Combination Sum II
=> candidates有重複, 有幾個重複才能用幾個 </br>
======================================== </br>

* 90 k Sum II  </br>
* 136 Palindrome Partitioning </br>
=> 加入記憶化搜索 </br>

To do:
192. Wildcard Matching


## DFS - permutation
// 排列: no start index, 用一個boolean[題目的長度]紀錄哪個點已經走過) </br>
// 題目中有重複的話, 先sort

```java
private void DFS(List<String> result,
                 List<String> subset,
                 char[] chars,
                 boolean[] visisted){

  // subset到達答案的長度, 加入result之中
  if (subset.size() == chars.length){
    result.add(... subset ... )
    // 相應處理: 
    // List<List<String>> result => result.add(new List<String>(subset));
    return;
  }

  // 有考慮重複的話,
  // 跟前面一樣 && 前面還沒被放入的 => 排除
  if (i > 0 && chars[i] == chars[i - 1] && visited[i - 1] == false){
      continue;
  }

  // loop through 可以被加入的項目
  for (int i = 0; i < chars.legnth; i ++){
    // 檢查是不是去過, 去過了跳過
    if (visited[i]){
      continue;
    }
    // 加入subset
    subset.add(Character.toString(chars[i]));
    visited[i] = true;
    DFS(result,
        subset,
        chars,
        visited);

    // backtracking
    visited[i] = false;
    subset.remove(subset.size() - 1);
  }
  
}
``` 
