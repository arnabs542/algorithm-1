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
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b != null){
            return false;
        }
        
        if (a != null && b == null){
            return false;
        }
        
        if (a == null && b == null){
            return true;
        }
        
        if (a.val != b.val){
            return false;
        }
        
        boolean leftIdentical = isIdentical(a.left, b.left);
        boolean rightIdentical = isIdentical(a.right, b.right);
        
        return leftIdentical && rightIdentical;
    }
}
