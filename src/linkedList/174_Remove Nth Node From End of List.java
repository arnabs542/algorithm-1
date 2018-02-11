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
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        
        for (int i = 0; i < n; i ++){
            fast = fast.next;
        }
        
        while (fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while(head.next != null){
            if (head.next == slow){
                head.next = slow.next;
                break;
            }
            head = head.next;
        }
        
        return dummy.next;
    }
}
