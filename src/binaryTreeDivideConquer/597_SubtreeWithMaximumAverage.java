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
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
     
    private class Result {
        public int result_sum;
        public int result_size;
        public Result(int sum, int size){
            this.result_sum = sum;
            this.result_size = size;
        }
    }
    
    private TreeNode subtree = null;
    private Result subtreeResult = null;
    
    public TreeNode findSubtree2(TreeNode root) {
        helper(root);
        return subtree;
    }
    
    public Result helper(TreeNode root){
        if (root == null){
            return new Result(0, 0);
        }
        
        Result resultL = helper(root.left);
        Result resultR = helper(root.right);
        Result resultRoot = new Result(
            resultL.result_sum + resultR.result_sum + root.val,
            resultL.result_size + resultR.result_size + 1
            );
        
        if (subtree == null || 
            // subtreeResult.result_sum / subtreeResult.result_size < 
            // resultRoot.result_sum / resultRoot.result_sum
            subtreeResult.result_sum * resultRoot.result_size < 
            resultRoot.result_sum * subtreeResult.result_size
            ){
            subtree = root;
            subtreeResult = resultRoot;
        }
        
        return resultRoot;
    }
}
