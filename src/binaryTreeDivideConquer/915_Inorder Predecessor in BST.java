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
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    private TreeNode pre = null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return pre;
    }
    
    private void dfs(TreeNode root, TreeNode p){
        if (root == null){
            return;
        }
        
        dfs(root.left, p);
        if (root == p){
            if (root.left != null){
                pre = root.left;
            }
            return;
        }
        
        if (root.val < p.val){
            pre = root;
            dfs(root.right, p);
        }
        
    }
}
