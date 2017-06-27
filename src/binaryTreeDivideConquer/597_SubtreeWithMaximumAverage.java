package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/6/27.
 */
public class 597_SubtreeWithMaximumAverage {

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
