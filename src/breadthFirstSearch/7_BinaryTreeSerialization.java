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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        StringBuilder s = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i ++){
                TreeNode n = q.poll();
                s.append(",");
                if (n == null){
                    s.append("#");
                } else {
                    s.append(Integer.toString(n.val));
                    q.offer(n.left);
                    q.offer(n.right);
                }
            }
        }
        
        return "{" + s.toString().substring(1, s.length()) + "}";
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        data = data.replace("{", "").replace("}", "");
        if (data == "" || data.equals("#")){
            return null;
        }
        String[] c = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(c[0]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean isLeftNode = true;
        for (int i = 1; i < c.length; i ++){
            if (!c[i].equals("#")){
                TreeNode newNode = new TreeNode(Integer.parseInt(c[i])); 

                if (isLeftNode){
                    q.peek().left = newNode;
                } else {
                    q.peek().right = newNode;
                }
                
                q.offer(newNode);
            } 
            
            // 加完右子樹, 就poll root
            if (!isLeftNode){
                q.poll();
            }
            isLeftNode = !isLeftNode;
        }
        
        return root;
    }
}
