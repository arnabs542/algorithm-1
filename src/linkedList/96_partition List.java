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
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        ListNode sHead = new ListNode(0);
        ListNode sHeadCurr;
        ListNode bHead = new ListNode(0);;
        ListNode bHeadCurr;
        
        sHeadCurr = sHead;
        bHeadCurr = bHead;
        while(head != null){
            if (head.val >= x){
                bHeadCurr.next = head;
                bHeadCurr = bHeadCurr.next;
            }else{
                sHeadCurr.next = head;
                sHeadCurr = sHeadCurr.next;
            }
            head = head.next;
        }
        bHeadCurr.next = null;
        sHeadCurr.next = bHead.next;
        return sHead.next;
        
    }
}
