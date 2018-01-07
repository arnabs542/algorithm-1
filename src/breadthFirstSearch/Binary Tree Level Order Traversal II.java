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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            for (int i = 0; i < size; i ++){
                TreeNode theNode = q.poll();
                level.add(theNode.val);
                
                if (theNode.left != null){
                    q.offer(theNode.left);
                }
                
                if (theNode.right != null){
                    q.offer(theNode.right);
                }
            }
            result.add(level);
        }
        
        Collections.reverse(result);
        return result;
    }
}
