// Solution 1) Priority Queue: O(nlogk)
// 總共n個數, k個練表(priority queue的大小)
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
    public ListNode mergeKLists(List<ListNode> lists) {  
        if (lists == null || lists.size() == 0){
            return null;
        }
        
        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator
            );
        
        for (int i = 0; i < lists.size(); i ++){
            if (lists.get(i) != null){
                pq.offer(lists.get(i));
            }
        }
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            curr.next = node;
            curr = node;
            if (node.next != null){
                pq.offer(node.next);
            }
        }
        
        return dummy.next;
    }
    
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>(){
        public int compare(ListNode a, ListNode b){
            return a.val - b.val;
        }
    };
}

// Solution 2) 兩倆合併, merge 2 sorted list: O(nlogk) 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        // divide & counquer
        // 把lists k 分到最小 再來合併
        return mergeHelper(lists, 0, lists.length - 1);
    }
    
    private ListNode mergeHelper(ListNode[] lists, int start, int end){
        if (start == end){
            return lists[start];
        }
        
        int mid = start + (end - start)/2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return merge(left, right);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        if (left == null){
            return right;
        }
        
        if (right == null){
            return left;
        }
        
        ListNode result = new ListNode(0);
        ListNode curr = result;
        while (left != null && right != null){
            if (left.val < right.val){
                curr.next = left;
                left = left.next;
            } else {
                curr.next = right;
                right = right.next;
            }
            
            curr = curr.next;
        }
        
        while (left != null){
            curr.next = left;
            curr = curr.next;
            left = left.next;
        }
        
        while (right != null){
            curr.next = right;
            curr = curr.next;
            right = right.next;
        }
        
        return result.next;
    }
}

// Solution 3) Merge sort 歸併排序 O(nlogk)

