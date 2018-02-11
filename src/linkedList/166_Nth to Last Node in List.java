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
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: Nth to last node of a singly linked list. 
     */
    public ListNode nthToLast(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        for (int i = 0; i < n; i ++){
            fast = fast.next;
        }
        
        while (slow != null && fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        return slow;
    }
}
