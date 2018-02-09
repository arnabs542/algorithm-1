
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
     * @param ListNode head is the head of the linked list 
     * @oaram m and n
     * @return: The head of the reversed ListNode
     */
    public ListNode reverseBetween(ListNode head, int m , int n) {
        if (n <= m || head == null){
            return head;
        }
        
        // add dummy node to handle special case when m = 1
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i ++){
            if (head == null){
                return null;
            }
            head = head.next;
        }
        
        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode mNodeNext = mNode.next;
        
        ListNode prev = null;
        ListNode curr = mNode;
        for (int i = m; i <= n; i ++){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        mNode.next = curr;
        preM.next = prev;
        return dummy.next;
        
    }
}
