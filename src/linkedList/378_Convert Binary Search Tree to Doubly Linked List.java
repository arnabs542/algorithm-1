/**
 * Definition for Doubly-ListNode.
 * public class DoublyListNode {
 *     int val;
 *     DoublyListNode next, prev;
 *     DoublyListNode(int val) {
 *         this.val = val;
 *         this.next = this.prev = null;
 *     }
 * } * Definition of TreeNode:
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
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    // L root R
    DoublyListNode dummy = new DoublyListNode(0);
    DoublyListNode curr = dummy;
        
    public DoublyListNode bstToDoublyList(TreeNode root) {
        
        traverse(root);
        
        return dummy.next;
    }
    
    private void traverse(TreeNode root){
        if (root == null){
            return;
        }
        
        traverse(root.left);
        DoublyListNode prev = curr;
        curr.next = new DoublyListNode(root.val);
        curr = curr.next;
        curr.prev = prev;
        traverse(root.right);
    }
    
    
}
