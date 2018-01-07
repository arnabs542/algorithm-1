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
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        int count = 0;
        while(!q.isEmpty()){
            List<Integer> level = new ArrayList<Integer>();
            int size = q.size();
            boolean isOdd = (count % 2 == 1);
            for (int i = 0; i < size; i++){
                TreeNode theNode = q.poll();
                level.add(theNode.val);
                
                if (theNode.left != null){
                        q.offer(theNode.left);
                    }
                if (theNode.right != null){
                        q.offer(theNode.right);
                    }
            }
            
            if (isOdd){
                Collections.reverse(level);
            }
            
            result.add(level);
            count++;
        }
        
        return result;
    }
}
