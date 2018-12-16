// divide and conqure
// O(nlog(k))

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    // merge sort 
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists.size() == 0){
            return null;
        }
        
        return divide(lists, 0, lists.size() - 1);
    }
    
    public ListNode divide(List<ListNode> lists, int start, int end){
        if (start >= end){
            return lists.get(start);
        }
        
        int mid = (start + end) / 2;
        
        ListNode leftList = divide(lists, start, mid);
        ListNode rightList = divide(lists, mid + 1, end);
        return merge(leftList, rightList);
    }
    
    public ListNode merge(ListNode leftList, ListNode rightList){
        if (leftList == null){
            return rightList;
        }
        
        if (rightList == null){
            return leftList;
        }
        
        ListNode currL = leftList;
        ListNode currR = rightList;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        
        while(currL != null && currR != null){
            if (currL.val < currR.val){
                tail.next = currL;
                currL = currL.next;
            } else{
                tail.next = currR;
                currR = currR.next;
            }
            
            tail = tail.next;
        }
        
        while(currL != null){
            tail.next = currL;
            tail = tail.next;
            currL = currL.next;
        }
        
        while(currR != null){
            tail.next = currR;
            tail = tail.next;
            currR = currR.next;
        }
        
        return head.next;
    }
}
