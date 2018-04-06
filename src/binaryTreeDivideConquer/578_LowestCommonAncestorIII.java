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
class ResultType{
    public boolean a_exist;
    public boolean b_exist;
    public ResultType(boolean a, boolean b){
        this.a_exist = a;
        this.b_exist = b;
    }

}

public class Solution {
    
    public TreeNode LCA = null;
    
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        helper(root, A, B);
        return LCA;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new ResultType(false, false);
        }
        
        ResultType leftResult = helper(root.left, A, B);
        ResultType rightResult = helper(root.right, A, B);
        ResultType result = new ResultType(false, false);
        
        result.a_exist = (leftResult.a_exist || rightResult.a_exist || root == A);
        result.b_exist = (leftResult.b_exist || rightResult.b_exist || root == B);
        
        if (LCA == null && result.a_exist && result.b_exist){
            LCA = root;
        }
        
        return result;

    }
}
