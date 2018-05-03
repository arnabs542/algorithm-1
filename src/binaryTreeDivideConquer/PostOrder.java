//左右根

package binaryTreeDivideConquer;

import java.util.ArrayList;

/**
 * Created by epingho on 2017/6/26.
 */
public class PostOrder {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }

        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));

        result.add(root.val);

        return result;
    }
}
