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
// DFS - combination (need start index)
/////////////////////////////




/////////////////////////////
// DFS - permutation (no need start index)
/////////////////////////////
// for loop nums array
// 用一個boolean[nums.length]紀錄哪個點已經走過
