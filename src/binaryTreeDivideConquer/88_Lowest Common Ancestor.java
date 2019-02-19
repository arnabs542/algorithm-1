// Sol 1.) 
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
class Result{
    public boolean a_exist;
    public boolean b_exist;
    public Result(boolean a_exist, boolean b_exist){
        this.a_exist = a_exist;
        this.b_exist = b_exist;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
     
    private TreeNode lca = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        helper(root, A, B);
        return lca;
    }
    
    private Result helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new Result(false, false);
        }
        
        Result resultL = helper(root.left, A, B);
        Result resultR = helper(root.right, A, B);
        
        boolean aExist = (resultL.a_exist || resultR.a_exist || root == A);
        boolean bExist = (resultL.b_exist || resultR.b_exist || root == B); 
        
        if (lca == null && aExist && bExist){
            lca = root;
        }
        
        return new Result(aExist, bExist);
    }
}

// Sol 2.) 
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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B){
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        
        return null;
    }
}
