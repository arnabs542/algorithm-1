package binaryTreeDivideConquer;

import java.util.ArrayList;

/**
 * Created by epingho on 2017/7/4.
 */
public class BinaryTreePathSum {
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        ArrayList<Integer> path = new ArrayList<Integer>();
        List<List<Integer>> resultList = new ArrayList<>();

        if (root == null){
            return resultList;
        }

        path.add(root.val);
        helper(root, target, root.val, path, resultList);

        return resultList;
    }

    public void helper(TreeNode root
            , int target
            , int sum
            , ArrayList<Integer> path
            , List<List<Integer>> resultList){

        if (root == null){
            return;
        }

        // valid path is from root to leaf
        if (root.left == null && root.right == null){
            if (sum == target){
                resultList.add(new ArrayList<Integer>(path));
            }
        }

        if (root.left != null){
            path.add(root.left.val);
            helper(root.left, target, sum + root.left.val, path, resultList);
            path.remove(path.size() - 1);
        }

        if (root.right != null){
            path.add(root.right.val);
            helper(root.right, target, sum + root.right.val, path, resultList);
            path.remove(path.size() - 1);
        }
    }
}
