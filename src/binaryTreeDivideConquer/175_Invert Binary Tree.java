/** Sol 1.) recursion
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        invert(root);
    }
    
    private void invert(TreeNode root){
        if (root == null){
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invert(root.left);
        invert(root.right);
    }
}

/** Sol 2.) iteration
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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    public void invertBinaryTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while (!s.isEmpty()){
            TreeNode n = s.pop();
            
            TreeNode temp = n.left;
            n.left = n.right;
            n.right = temp;
            
            if (n.left != null){
                s.push(n.left);
            }
            
            if (n.right != null){
                s.push(n.right);
            }
        }
    }
}

/** Sol 3.) iteration

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return root;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()){
            TreeNode n = q.poll();
            TreeNode temp;
            temp = n.left;
            n.left = n.right;
            n.right = temp;
            if (n.left != null){
                q.offer(n.left);
            }
            if (n.right != null){
                q.offer(n.right);
            }
        }
        
        return root;
    }
}
