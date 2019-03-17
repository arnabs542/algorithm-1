/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null){
            return null;
        }
        
        if (head.next == null){
            return new TreeNode(head.val);
        }
        // 1. find pre-middle, 因為之後要把鍊錶從middle斷開, 且middle已經成為tree node, 要刪除
        ListNode preMiddle = findPrevMiddle(head);
        // let middle.next to be root
        TreeNode root = new TreeNode(preMiddle.next.val);
        root.right = sortedListToBST(preMiddle.next.next);
        preMiddle.next = null;
        root.left = sortedListToBST(head);
        
        return root;
    }
    
    private ListNode findPrevMiddle(ListNode head){
        if (head == null || head.next == null){
            return null;
        }
        
        ListNode fast = head.next;
        ListNode slow = head;
        ListNode prevSlow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }
        return prevSlow;
    }
}
