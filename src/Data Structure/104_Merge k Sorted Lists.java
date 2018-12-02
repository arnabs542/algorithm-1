// O(nlogk)
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
