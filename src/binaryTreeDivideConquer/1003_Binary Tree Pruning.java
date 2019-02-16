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
     * @param root: the root
     * @return: the same tree where every subtree (of the given tree) not containing a 1 has been removed
     */
    public TreeNode pruneTree(TreeNode root) {
        prune(root);
        return root;
    }
    
    private TreeNode prune(TreeNode root){
        if (root == null){
            return null;
        }
        
        root.left = prune(root.left);
        root.right = prune(root.right);
        
        if (root.val == 0){
            if (root.left == null && root.right == null){
                return null;
            }
        } 
        return root;
    }
}
