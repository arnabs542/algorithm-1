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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list,
                    using constant space complexity.
     */
    public ListNode sortList(ListNode head) {  
        // **
        if (head == null || head.next == null){
            return head;
        }
        
        ListNode middle = findMiddle(head);
        ListNode right = sortList(middle.next);
        middle.next = null; 
        ListNode left = sortList(head);
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        
        // **
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        while (left != null && right != null){
            if (left.val < right.val){
                tail.next = left;
                left = left.next;
            }else{
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }
        
        if (left != null){
            tail.next = left;
        }
        
        if (right != null){
            tail.next = right;
        }
        
        return dummy.next;
    }
}
