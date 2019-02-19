// Sol 1.) 考慮BST特性... iteration O(h)

public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    // Left, Root, Right
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        TreeNode pred = null;
        
        while(root != null){
            if (root.val >= p.val){
                root = root.left;
            } else {
                pred = root;
                root = root.right;
            }
        }
        
        return pred;
        
    }
}

// Sol 2.) 考慮BST特性... recursion O(h)

public class Solution {
    /**
     * @param root: the given BST
     * @param p: the given node
     * @return: the in-order predecessor of the given node in the BST
     */
    // Left, Root, Right
    TreeNode pred = null;
    public TreeNode inorderPredecessor(TreeNode root, TreeNode p) {
        helper(root, p);
        return pred;
    }
    
    private void helper(TreeNode root, TreeNode p){
        if (root == null){
            return;
        }
        
        if (root.val >= p.val){
            helper(root.left, p);
        } else {
            pred = root;
            helper(root.right, p);
        }
    }
}

// Sol 3.) 沒有考慮BST特性... 直接in-oder
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
