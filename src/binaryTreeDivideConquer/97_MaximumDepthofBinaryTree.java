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



/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        helper(root, 0);
        return maxDepth;
    }
    
    private int maxDepth = Integer.MIN_VALUE;
    private void helper(TreeNode root, int step){
        if (root == null){
            return;
        }
        
        step ++;
        if (root.left == null && root.right == null){
            maxDepth = Math.max(maxDepth, step);
            return;
        }
        
        helper(root.left, step);
        helper(root.right, step);
    }
}
