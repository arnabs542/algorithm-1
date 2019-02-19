// Sol 1.) 考慮BST特性 ... iteration O(h)
public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    // Left, Root, Right
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        
        while (root != null){
            if (root.val > p.val){
                succ = root;
                root = root.left;
            }else{
                root = root.right;
            }
        }
        
        return succ;
    }
}


// Sol 2.) 考慮BST特性 ... recursion O(h)

public class Solution {
    /*
     * @param root: The root of the BST.
     * @param p: You need find the successor node of p.
     * @return: Successor of p.
     */
    // Left, Root, Right

    TreeNode succ = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        helper(root, p);
        
        return succ;
    }
    
    private void helper(TreeNode root, TreeNode p){
        if (root == null){
            return;
        }
        
        if (root.val > p.val){
            succ = root;
            helper(root.left, p);
        } else {
            helper(root.right, p);
        }
    }
}
