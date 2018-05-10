/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        return getDepth(root);
    }
    
    private int getDepth(TreeNode root){
        if (root == null){
            return Integer.MIN_VALUE;
        }
        
        if (root.left == null && root.right == null){
            return 1;
        }
        
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
