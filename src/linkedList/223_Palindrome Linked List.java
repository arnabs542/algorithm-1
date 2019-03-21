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
     * @param head: A ListNode.
     * @return: A boolean.
     */
    // normal test case: 1-> -> 2 -> 1 
    // result: true
    
    // naive test case: null
    // result: true
    
    // special test case: 1 -> 2 -> null
    // result fasle
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }
        
        ListNode middle = findMiddle(head);
        ListNode reversed = reverse(middle.next);
        
        ListNode p1 = head;
        ListNode p2 = reversed;
        while (p1 != null && p2 != null && p1.val == p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        
        return p2 == null;
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
