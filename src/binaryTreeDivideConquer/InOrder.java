package binaryTreeDivideConquer;

import java.util.ArrayList;

/**
 * Created by epingho on 2017/6/26.
 */
public class InOrder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));

        return result;
    }
}
