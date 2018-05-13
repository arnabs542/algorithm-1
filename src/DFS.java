/////////////////////////////
// DFS on Tree - inorder travesal
/////////////////////////////

public void inoder(TreeNode root, List<Integer> result){
  if (root == null){
    return;
  }
  
  inorder(root.left, result);
  result.add(root);
  inorder(root.right, result);
}


/////////////////////////////
// DFS - combination 
// (need start index)
// 組合: 選過不用再選
/////////////////////////////




/////////////////////////////
// DFS - permutation
// 排列: no start index, 用一個boolean[題目的長度]紀錄哪個點已經走過)
/////////////////////////////
// 題目中有重複的話, 先sort

private void DFS(List<String> result,
                 List<String> subset,
                 char[] chars,
                 boolean[] visisted)

  // subset到達答案的長度, 加入result之中
  if (subset.size() == chars.length){
    result.add(... subset ... )
    // 相應處理: 
    // List<List<String>> result => result.add(new List<String>(subset));
  }

  // 有考慮重複的話,
  // 跟前面一樣 而且 前面還沒被放入的 => 排除
  if (i > 0 && chars[i] == chars[i - 1] && visited[i - 1] == false){
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
)
