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
        if (root == null){
            return 0;
        }
        
        TreeNode lowerBound = findLowerBound(root, target);
        TreeNode upperBound = findUpperBound(root, target);
        if (lowerBound == null){
            return upperBound.val;
        }
        
        if (upperBound == null){
            return lowerBound.val;
        }
        
        if (Math.abs(target - lowerBound.val) > Math.abs(target - upperBound.val)){
            return upperBound.val;
        }else{
            return lowerBound.val;
        }
    }
    
    private TreeNode findLowerBound(TreeNode root, double target){
        if (root == null){
            return root;
        }
        
        if (root.val >= target){
            // 往left去找
            return findLowerBound(root.left, target);
        }
        else { 
            // root.val < target
            // 往right去找
            TreeNode lowerBound = findLowerBound(root.right, target);
            if (lowerBound != null){
                return lowerBound;
            }
        }
        
        return root;
    }
    
    private TreeNode findUpperBound(TreeNode root, double target){
        if (root == null){
            return root;
        }
        
        if (root.val < target){
            // 往right去找
            return findUpperBound(root.right, target);
        }
        else { 
            // root.val < target
            // 往left去找
            TreeNode upperBound = findUpperBound(root.left, target);
            if (upperBound != null){
                return upperBound;
            }
        }
        
        return root;
    }
}
