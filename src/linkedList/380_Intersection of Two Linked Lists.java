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
     * @param headA: the first list
     * @param headB: the second list
     * @return: a ListNode
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        
        ListNode curr = headA;
        while (curr.next != null){
            curr = curr.next;
        }
        
        curr.next = headB;
        ListNode result = hasCycle(headA);
        curr.next = null;
        return result;
    }
    
    private ListNode hasCycle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        boolean hasCycle = false;
        
        while(fast != null && fast.next != null){
            if (fast == slow){
                hasCycle = true;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        
        if (hasCycle){
            while (head != slow.next){
                head = head.next;
                slow = slow.next;
            }
            return head;
        }
       
        
        return null;

    }
}
