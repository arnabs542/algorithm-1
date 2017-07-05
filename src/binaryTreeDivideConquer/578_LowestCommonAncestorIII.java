package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/7/4.
 */

class Result {
    boolean a_exists;
    boolean b_exists;
    TreeNode node;
    public Result(boolean a_exists, boolean b_exists, TreeNode node){
        this.a_exists = a_exists;
        this.b_exists = b_exists;
        this.node = node;
    }
}

public class LowestCommonAncestorIII {
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B)
    {
        Result lowestCommonAncestorResult = helper(root, A, B);

        if (lowestCommonAncestorResult.a_exists && lowestCommonAncestorResult.b_exists){
            return lowestCommonAncestorResult.node;
        }else{
            return null;
        }
    }

    public Result helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new Result(false, false, null);
        }

        Result result_A = helper(root.left, A, B);
        Result result_B = helper(root.right, A, B);

        boolean a_exists = (root == A || result_A.a_exists || result_B.a_exists);
        boolean b_exists = (root == B || result_A.b_exists || result_B.b_exists);

        if (root == A || root == B){
            return new Result(a_exists, b_exists, root);
        }
        if (result_A.node != null && result_B.node != null){
            return new Result(a_exists, b_exists, root);
        }

        if (result_A.node != null){
            return new Result(a_exists, b_exists, result_A.node);
        }

        if (result_B.node != null){
            return new Result(a_exists, b_exists, result_B.node);
        }

        return new Result(a_exists, b_exists, null);

    }
}
