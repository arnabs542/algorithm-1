package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/6/26.
 */
public class 97_MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (root == null){
            return 0;
        }

        leftDepth = maxDepth(root.left);
        rightDepth = maxDepth(root.right);

        if (leftDepth > rightDepth){
            return leftDepth + 1;
        }else {
            return rightDepth + 1;
        }
    }
}
