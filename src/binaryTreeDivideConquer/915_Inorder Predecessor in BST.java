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
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    private TreeNode pre = null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        dfs(root, p);
        return pre;
    }
    
    private void dfs(TreeNode root, TreeNode p){
        if (root == null){
            return;
        }
        
        dfs(root.left, p);
        if (root == p){
            if (root.left != null){
                pre = root.left;
            }
            return;
        }
        
        if (root.val < p.val){
            pre = root;
            dfs(root.right, p);
        }
        
    }
}


// Sol 2.) 沒有考慮BST特性... 直接in-oder
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
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    
    //   2
    //  /\
    // 1  3
    // inorder: [1, 2, 3]
    // left, root, right
    // predecessor of 1: null
    
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        helper(root, result);
        for (int i = 0; i < result.size(); i ++){
            if (p == result.get(i)){
                if (i == 0){
                    break;
                }
                
                return result.get(i - 1);
            }
        }
        
        return null;
    }
    
    private void helper(TreeNode root, List<TreeNode> result){
        if (root == null){
            return;
        }
        
        helper(root.left, result);
        result.add(root);
        helper(root.right, result);
    }
}
