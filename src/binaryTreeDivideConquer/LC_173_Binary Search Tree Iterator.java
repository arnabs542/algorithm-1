/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator {
    
    Stack<TreeNode> s;
    public BSTIterator(TreeNode root) {
        s = new Stack<TreeNode>();
        build(root);
    }
    
    private void build(TreeNode root){
        if (root == null){
            return;
        }
        
        build(root.right);
        s.push(root);
        build(root.left);
    }
    
    /** @return the next smallest number */
    public int next() {
        if (s.peek() != null){
            TreeNode n = s.pop();
            return n.val;
        }
        
        return -1;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (s != null && s.size() > 0);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
