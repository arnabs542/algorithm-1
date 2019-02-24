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
    /*
     * @param root: The root of the binary search tree.
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
     
    private int max;
    public TreeNode removeNode(TreeNode root, int value) {
        if (root == null){
            return null;
        }
        
        if (root.val == value){
            // node has no child (leaf) => 直接刪
            if (root.left == null && root.right == null){
                return null;
            } 
            
            // node has only left or only right => 直接補上來
            if (root.left == null && root.right !=  null){
                return root.right;
            }
            
            if (root.left != null && root.right == null){
                return root.left;
            }
            
            // node has both left and right => replace the value by max value of left TreeNode
            //                              => remove the node from left tree
            root.left = findMaxAndRemove(root.left);
            root.val = max;
            
        } else if (root.val > value){
            root.left = removeNode(root.left, value);
        } else {
            root.right = removeNode(root.right, value);
        }
            
        return root;
        
    }
    
    // find Max and remove it
    private TreeNode findMaxAndRemove(TreeNode root){
        if (root.right != null){
            root.right = findMaxAndRemove(root.right);
            return root.right;
        }
        max = root.val;
        return null;
        
    }
}
