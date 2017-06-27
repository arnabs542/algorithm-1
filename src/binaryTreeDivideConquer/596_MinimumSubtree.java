package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/6/26.
 */
public class 596_MinimumSubtree {
    /**
     * @param root the root of binary tree
     * @return the root of the minimum subtree
     */
    private TreeNode subtree = null;
    private int subtreeSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        helper(root);
        return subtree;
    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int sum = root.val + helper(root.left) + helper(root.right);
        if (sum <= subtreeSum){
            subtreeSum = sum;
            subtree = root;
        }

        return sum;
    }
}
