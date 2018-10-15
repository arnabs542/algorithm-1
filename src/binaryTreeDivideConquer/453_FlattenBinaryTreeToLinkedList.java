package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/6/29.
 */
public class FlattenBinaryTreeToLinkedList {
    private TreeNode resultNode = null;
    public void flatten(TreeNode root) {
        if (root == null){
            return;
        }


        if (resultNode == null){
            resultNode = root;
        }else{
            resultNode.left = null;
            resultNode.right = root;
        }

        resultNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }
}


// divide and conquer
public class Solution {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode root){
        if (root == null){
            return null;
        }
        
        TreeNode leftLast = helper(root.left);
        TreeNode rightLast = helper(root.right);
        
        if(leftLast != null){
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if (rightLast != null){
            return rightLast;
        }
        
        if (leftLast != null){
            return leftLast;
        }
        
        return root;
    }
}
