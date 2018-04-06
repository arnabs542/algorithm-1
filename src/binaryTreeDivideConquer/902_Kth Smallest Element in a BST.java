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
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
     
    public int index  = 0;
    public int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kth;
    }
    
    private void inorder(TreeNode root, int k){
        if (root == null){
            return;
        }
        
        inorder(root.left, k);
        index ++;
        if (index == k){
            kth = root.val;
        }
        
        if (index < k){
            inorder(root.right, k);
        }
        
    }
}
