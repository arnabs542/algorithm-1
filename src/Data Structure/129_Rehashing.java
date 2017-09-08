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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0){
            return null;
        }
        
        int newSize = hashTable.length * 2;
        ListNode[] newHashTable = new ListNode[newSize];
        for (int i = 0; i < hashTable.length; i++){
            while (hashTable[i] != null){
                ListNode curr = hashTable[i];
                int newIndex = (curr.val % newSize + newSize) % newSize;
                if (newHashTable[newIndex] == null){
                    newHashTable[newIndex] = new ListNode(curr.val);
                }else{
                    ListNode dummy = newHashTable[newIndex];
                    while (dummy.next != null){
                        dummy = dummy.next;
                    }
                    dummy.next = new ListNode(curr.val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }
        
        return newHashTable;
    }
};
