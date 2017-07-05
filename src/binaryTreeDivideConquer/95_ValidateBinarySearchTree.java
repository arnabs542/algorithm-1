package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/7/4.
 */
public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper (TreeNode root, long min, long max){
        if (root == null){
            return true;
        }

        if (root.val >= max || root.val <= min){
            return false;
        }

        return helper(root.left, min, Math.min(root.val, max))
                && helper(root.right, Math.max(root.val, min), max);
    }
}
