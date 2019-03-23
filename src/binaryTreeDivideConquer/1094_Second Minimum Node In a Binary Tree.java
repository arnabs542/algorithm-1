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
     * @return: the second minimum value in the set made of all the nodes' value in the whole tree
     */
    int min = -1;
    int x = -1;
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null){
            return -1;
        }
        min = root.val;
        helper(root);
        return x;
    }
    
    private void helper(TreeNode root){
        if (root == null){
            return;
        }
        
        if (root.val > min){
            x = root.val;
            return;
        }
        
        if (root.left == null || root.left == null){
            return;
        }
        
        if (root.left.val < root.right.val){
            helper(root.left);
            helper(root.right);
        } else {
            helper(root.right);
            helper(root.left);
        }
    }
}
