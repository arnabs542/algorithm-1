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
     * @param root: the root of binary tree.
     * @return: An integer
     */
    public int max = Integer.MIN_VALUE;
    public int maxPathSum2(TreeNode root) {
        helper(root, 0);
        return max;
    }
    
    // root, left ,right
    private void helper(TreeNode root, int preSum){
        if (root == null){
            return;
        }
        
        int currSum = preSum + root.val;
        max = Math.max(max, currSum);
        helper(root.left, currSum);
        helper(root.right, currSum);
    }
}
