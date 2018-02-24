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
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: The first node of linked list.
     * @return: a tree node
     */
    ListNode curr = null;
    public TreeNode sortedListToBST(ListNode head) {
        curr = head;
        
        int listLength = listCount(head);
        return sortedListToBSTHelper(listLength);
    }
    
    private TreeNode sortedListToBSTHelper(int listLength){
        if (listLength <= 0){
            return null;
        }
        
        TreeNode left = sortedListToBSTHelper(listLength/2);
        TreeNode root = new TreeNode(curr.val);
        curr = curr.next;
        TreeNode right = sortedListToBSTHelper(listLength - 1 - listLength/2);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
    
    private int listCount(ListNode head){
        int count = 0;
        while(head != null){
            head = head.next;
            count ++;
        }
        return count;
    } 
    
}
