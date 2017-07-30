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
    /**
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        if (head == null || head.next == null){
            return false;
        }
        
        ListNode step1;
        ListNode step2;
        step1 = head;
        step2 = head.next;
        
        while (step1 != step2){
            //!!! check boundery !!!!
            if (step2 == null || step2.next == null){
                return false;
            }
            
            step1 = step1.next;
            step2 = step2.next.next;
        }
        return true;
    }
}
