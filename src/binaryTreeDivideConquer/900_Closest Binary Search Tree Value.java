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
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        TreeNode lower = findLowerBound(root, target);
        TreeNode upper = findUpperBound(root, target);
        
        if (lower == null) return upper.val;
        if (upper == null) return lower.val;
        if (Math.abs(lower.val - target) > Math.abs(upper.val - target)){
            return upper.val;
        }else{
            return lower.val;
        }

    }
    
    public TreeNode findLowerBound(TreeNode root, double target){
        if (root == null){
            return null;
        }
        
        if (root.val <= target){
            // val 比 target 小, 往右找
            // 最後還是比target小, 就是lower bound 
            TreeNode lowewrBound = findLowerBound(root.right, target);
            if (lowewrBound == null){
                return root;
            }else{
                return lowewrBound;
            }
        } else {
            // val 比 target 大, 往左找
            // 最後還是比target大的話, return null, 沒有lower bound
            return findLowerBound(root.left, target);
        }
    }
    
    public TreeNode findUpperBound(TreeNode root, double target){
        if (root == null){
            return null;
        }
        
        if (root.val <= target){
            // val 比 target 小, 往右找
            // 最後還是比target小, 就是沒有upper bound, return null
            return findUpperBound(root.right, target);
        } else {
            // val 比 target 大, 往左找
            // 最後還是比target大的話, 就是upper bound
            TreeNode upperBound = findUpperBound(root.left, target);
            if (upperBound == null){
                return root;
            }else{
                return upperBound;
            }
        }
    }
}
