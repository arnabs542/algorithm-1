/** Sol 1.) recursion
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        invert(root);
    }
    
    private void invert(TreeNode root){
        if (root == null){
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invert(root.left);
        invert(root.right);
    }
}

/** Sol 2.) iteration

