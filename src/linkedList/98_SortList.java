//* 1.) merge sort

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
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    // merge sort  
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        // 1. find middle
        ListNode middle = findMiddle(head);
        
        // sort right
        ListNode right = sortList(middle.next);
        middle.next = null;
        // sort left
        ListNode left = sortList(head);
        
        // merge
        return merge(left, right);
    }
    
    private ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        return slow;
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode l = left;
        ListNode r = right;
        while (l != null && r != null){
            if (l.val < r.val){
                curr.next = l;
                curr = curr.next;
                l = l.next;
            } else {
                curr.next = r;
                curr = curr.next;
                r = r.next;
            }
        }
        
        if (l != null){
            curr.next = l;
            curr = curr.next;
            l = l.next;
        }
        
        if (r != null){
            curr.next = r;
            curr = curr.next;
            r = r.next;
        }
        
        return dummy.next;
    }
}
