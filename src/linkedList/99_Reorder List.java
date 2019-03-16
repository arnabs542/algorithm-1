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
     * @param head: The head of linked list.
     * @return: nothing
     */
    public void reorderList(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode node = head;
        while(node != null){
            s.push(node);
            node = node.next; 
        }
        
        int size = s.size();
        if (size <= 2){
            return;
        }
        ListNode curr = head;
        while(s.size() > Math.ceil((double) size/2)){
            ListNode insertNode = s.pop();
            ListNode temp = curr.next;
            insertNode.next = temp;
            curr.next = insertNode;
            curr = curr.next.next;
        }
        
        curr.next = null;
    }
}
