package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/7/4.
 */

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
