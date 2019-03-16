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
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public ListNode swapNodes(ListNode head, int v1, int v2) {
       ListNode curr = head;
       ListNode v1Node = null;
       ListNode v2Node = null;
       while (curr != null){
           if (curr.val == v1){
               v1Node = curr;
           } 
           
           if (curr.val == v2){
               v2Node = curr;
           }
           
           if (v1Node != null && v2Node != null){
                v1Node.val = v2;
                v2Node.val = v1;
                break;
           }
           curr = curr.next;
       }
       
       return head;
       
    }
}
