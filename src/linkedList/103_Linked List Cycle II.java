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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null){
            return null;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null){
            if (fast == slow){
                hasCycle = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (!hasCycle){
            return null;
        }
        
        while (head != slow.next){
            head = head.next;
            slow = slow.next;
        }
        
        return slow.next;
    }
}
