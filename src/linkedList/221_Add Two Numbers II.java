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
     * @param l1: The first list.
     * @param l2: The second list.
     * @return: the sum list of l1 and l2.
     */
    public ListNode addLists2(ListNode l1, ListNode l2) {
        ListNode rL1 = reverse(l1);
        ListNode rL2 = reverse(l2);
        ListNode result = new ListNode(0);
        ListNode curr = result;
        
        int x = 0;
        int next = 0;
        while (rL1 != null && rL2 != null){
            int val = (next + rL1.val + rL2.val) % 10;
            next = (next + rL1.val + rL2.val) / 10;
            
            ListNode n = new ListNode(val);
            curr.next = n;
            curr = curr.next;
            rL1 = rL1.next;
            rL2 = rL2.next;
        }
        
        while (rL1 != null){
            int val = (next + rL1.val) % 10;
            next = (next + rL1.val) / 10;
            
            ListNode n = new ListNode(val);
            curr.next = n;
            curr = curr.next;
            rL1 = rL1.next;
        }
        
        while (rL2 != null){
            int val = (next + rL2.val) % 10;
            next = (next + rL2.val) / 10;
            
            ListNode n = new ListNode(val);
            curr.next = n;
            curr = curr.next;
            rL2 = rL2.next;
        }
        
        if (next > 0){
            ListNode n = new ListNode(next);
            curr.next = n;
            curr = curr.next;
        }
        
        return reverse(result.next);
        
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
