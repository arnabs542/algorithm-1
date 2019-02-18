// Sol 1.) iteration

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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    public enum Operation{
      PROCESS,
      ADDTORESULT
    }
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        Stack<Operation> op = new Stack<Operation>();

        s.push(root);
        op.push(Operation.PROCESS);
        
        while(!s.isEmpty()){
            TreeNode n = s.pop();
            Operation o = op.pop();
            if (n == null){
                continue;
            }
            
            if (o == Operation.ADDTORESULT){
                result.add(n.val);
            } else {
                s.push(n);
                op.push(Operation.ADDTORESULT);
                
                s.push(n.right);
                op.push(Operation.PROCESS);
                
                s.push(n.left);
                op.push(Operation.PROCESS);
            }
        }
        
        return result;
    }
}

// Sol 2.) recursion

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
     * @param root: A Tree
     * @return: Postorder in ArrayList which contains node values.
     */
    // left, right, root
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        
        return result;
    }
    
    private void helper(TreeNode root, List<Integer> result){
        if (root == null){
            return;
        }
        
        helper(root.left, result);
        helper(root.right, result);
        result.add(root.val);
        return;

    }
}
