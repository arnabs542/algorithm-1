/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> result = new ArrayList<Integer>();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null){
            return result;
        }
        
        result.add(root.val);
        DFSLeft(root.left);
        if (root.left != null || root.right != null){
            DFSLeaf(root);
        }
        DFSRight(root.right);
        
        return result;
        
    }
    
    private void DFSLeft(TreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        
        result.add(root.val);

        if (root.left == null){
            DFSLeft(root.right);
        } else {
            DFSLeft(root.left);
        }
    }
    
    private void DFSLeaf(TreeNode root){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            result.add(root.val);
        }
        DFSLeaf(root.left);
        DFSLeaf(root.right);
    }
    
    private void DFSRight(TreeNode root){
        if (root == null || (root.left == null && root.right == null)){
            return;
        }
        
        if (root.right == null){
            DFSRight(root.left);
        } else {
            DFSRight(root.right);
        }
        result.add(root.val);
    }
}
