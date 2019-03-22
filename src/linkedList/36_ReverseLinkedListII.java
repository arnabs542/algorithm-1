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
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        
        for (int i = 0; i < m - 1; i ++){
            head = head.next;
        }
        
        ListNode preM = null;
        ListNode mStart = null;
        ListNode postN = null;
        
        preM = head;
        
        ListNode reversed = reverse(head.next, n - m);
        preM.next = reversed;
        
        return dummy.next;
    }
    
    private ListNode reverse(ListNode head, int n){
        ListNode prev = null;
        ListNode curr = null;
        ListNode next = null;
        
        prev = head;
        curr = head.next;
        for (int i = 0; i < n; i ++){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        head.next = curr;
        return prev;
    }
}
