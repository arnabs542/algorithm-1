/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    // naive case: head: null
    // result: null;
    
    // special case: 1 -> 1-> null
    // result: null
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast){
            if (fast == null || fast.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        
        return head;
    }
}
