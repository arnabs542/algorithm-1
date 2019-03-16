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
     * @param head: a singly linked list
     * @return: Modified linked list
     */
    public ListNode oddEvenList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head;
        Queue<ListNode> q = new LinkedList<>();
        
        while (curr != null && curr.next != null){
            q.offer(curr.next);
            if (curr.next.next == null){
                break;
            }
            
            curr.next = curr.next.next;
            curr = curr.next;
        }
        
        while(!q.isEmpty()){
            curr.next = q.poll();
            curr = curr.next;
        }
        
        curr.next = null;
        
        return dummy.next;
    }
}
