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
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    // 加法是由個位進行, 剛好跟reverse order一樣 
    public ListNode addLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null){
            return null;
        }
        
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int sum = 0;
        int carry = 0; // 進位
        
        while (l1 != null && l2 != null){
            sum = (l1.val + l2.val) + carry;
            ListNode n = new ListNode(sum % 10);
            curr.next = n;
            curr = curr.next;
            
            carry = sum / 10; // 進位
            l1 = l1.next;
            l2 = l2.next;
        }
        
        while(l1 != null){
           sum = l1.val + carry; 
           ListNode n = new ListNode(sum % 10);
           curr.next = n;
           curr = curr.next;
           
           carry = sum / 10;
           l1 = l1.next;
        }
        
        while(l2 != null){
           sum = l2.val + carry; 
           ListNode n = new ListNode(sum % 10);
           curr.next = n;
           curr = curr.next;
            
            carry = sum / 10;
           l2 = l2.next;
        }
        
        if (carry != 0){
            ListNode n = new ListNode(carry);
            curr.next = n;
        }
        
        return result.next;
    }
}
