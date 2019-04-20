/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// level order
// get the last node from the level

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }
        
        result = BFS(root);
        
        return result;
    }
    
    private List<Integer> BFS(TreeNode root){
        List<Integer> levelOrderResult = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i ++){
                TreeNode n = q.poll();
                if (i == size - 1){
                    levelOrderResult.add(n.val);
                }
                if (n.left != null){
                    q.offer(n.left);
                }
                if (n.right != null){
                    q.offer(n.right);
                }
            }
        }
        
        return levelOrderResult;
    }
}
