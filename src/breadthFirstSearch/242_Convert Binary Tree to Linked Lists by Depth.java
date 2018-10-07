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
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> result = new ArrayList<ListNode>();
        if (root == null){
            return result;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            ListNode list = new ListNode(0);
            ListNode head;
            head = list;
            for (int i = 0; i < size; i ++){
                TreeNode n = q.poll();
                list.next = new ListNode(n.val);
                list = list.next;
                if (n.left != null){
                    q.offer(n.left);
                }
                if (n.right != null){
                    q.offer(n.right);
                }
            }
            
            result.add(head.next);
        }
        
        return result;
    }
}
