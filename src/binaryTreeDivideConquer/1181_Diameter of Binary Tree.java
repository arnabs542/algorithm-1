/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 不一定要經過樹根
class Solution {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxDepth(root);
        return max;
    }
    
    private int max = Integer.MIN_VALUE;
    private int maxDepth(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int maxL = maxDepth(root.left);
        int maxR = maxDepth(root.right);
        max = Math.max(max, maxL + maxR);
        return Math.max(maxL, maxR) + 1;
    }
}
