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
