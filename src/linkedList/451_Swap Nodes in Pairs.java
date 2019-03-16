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
     * @param head: a ListNode
     * @return: a ListNode
     */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null){
            head = swap(head);
            if (head == null){
                break;
            }
        }
        
        return dummy.next;
    }
    
    private ListNode swap(ListNode head){
        ListNode start = head.next;
        ListNode prev = head.next;
        ListNode curr = head.next.next;
        ListNode next;
        
        if (curr == null){
            return null;
        }
        
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
        
        head.next = prev;
        start.next = curr;
        return start;
    }
}
