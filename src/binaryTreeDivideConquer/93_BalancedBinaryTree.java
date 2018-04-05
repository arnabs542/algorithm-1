package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/7/4.
 */

///////////////////////////
//// Solution 1
///////////////////////////

class ResultType{
    public boolean isBalanced;
    public int maxDepth;
    public ResultType(boolean isBalanced, int maxDepth){
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        ResultType resultRoot = helper(root);
        return resultRoot.isBalanced;
    }

    public ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(true, 0);
        }

        ResultType resultL = helper(root.left);
        ResultType resultR = helper(root.right);

        if (Math.abs(resultL.maxDepth - resultR.maxDepth) > 1){
            return new ResultType(false, -1);
        }

        if (!resultL.isBalanced|| !resultR.isBalanced){
            return new ResultType(false, -1);
        }

        int depth = Math.max(resultL.maxDepth, resultR.maxDepth) + 1;
        return new ResultType(true, depth);

    }
}


///////////////////////////
//// Solution 2
///////////////////////////
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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return (depth(root) != -1);
    }
    
    private int depth(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1){
            return -1;
        } else {
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }
}
