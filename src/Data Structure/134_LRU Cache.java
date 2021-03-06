// Time: O(1)
// Space: O(capacity)

// solution 1: insert to last
public class LRUCache {

    private class Node{
        Node prev;
        Node next;
        int key;
        int value;
        
        public Node(int key, int value){
            this.prev = null;
            this.next = null;
            this.key = key;
            this.value = value;
        }
    }
    
    private HashMap<Integer, Node> hashmap = new HashMap<Integer, Node>();
    private Node tailNode = new Node(-1, -1);
    private Node headNode = new Node(-1, -1);
    private int capacity;
    
    // @param capacity, an integer
    public LRUCache(int capacity) {
        this.capacity = capacity;
        headNode.next = tailNode;
        tailNode.prev = headNode;
    }

    // @return an integer
    public int get(int key) {
        if (hashmap.containsKey(key)){
            Node selectedNode = hashmap.get(key);
            
            //remove selected key
            selectedNode.prev.next = selectedNode.next;
            selectedNode.next.prev = selectedNode.prev;
            
            //insert to last
            insertToLast(selectedNode);
            
            return selectedNode.value;
        }else{
            return -1;
        }
    }

    // @param key, an integer
    // @param value, an integer
    // @return nothing
    public void set(int key, int value) {
        if (get(key) != -1) {
            hashmap.get(key).value = value;
            return;
        }
        
        if (hashmap.size() == capacity){
            // remove from hashmap
            hashmap.remove(headNode.next.key);
          
            // remove the firstNode
            headNode.next = headNode.next.next;
            headNode.next.prev = headNode;
        }
            // insert to last
            Node newNode = new Node(key, value);
            insertToLast(newNode);
          
            // insert to hashmap
            hashmap.put(key, newNode);
    }
    
    
    private void insertToLast(Node newNode){
        newNode.prev = tailNode.prev;
        tailNode.prev.next = newNode;
        newNode.next = tailNode;
        tailNode.prev = newNode;
    }
}



// solution 2: insert to head
class ListNode{
    public int key;
    public int value;
    public ListNode next;
    public ListNode prev;
    public ListNode(int key, int val){
        this.key = key;
        this.value = val;
    }
}

public class LRUCache {
    /*
    * @param capacity: An integer
    */
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    Map<Integer, ListNode> hm = new HashMap<>();
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!hm.containsKey(key)){
            return -1;
        }
        
        ListNode curr = hm.get(key);
        if (head.next == curr){
            return curr.value;
        }
        
        // 先斷開
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        // 插入頭
        insertToHead(curr);
        return curr.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1){
            hm.get(key).value = value;
            return;
        }
        
        ListNode curr = new ListNode(key, value);
        if (hm.size() == capacity){
            hm.remove(tail.prev.key);
            tail.prev.prev.next = tail;
            tail.prev = tail.prev.prev;
        }
        
        hm.put(key, curr);
        insertToHead(curr);
    }
    
    private void insertToHead(ListNode curr){
        ListNode temp = head.next;
        head.next = curr;
        curr.prev = head;
        curr.next = temp;
        temp.prev = curr;
    }
}

// solution 3: use singly linked list
// hashmap存的是<key, 前一個節點>
class ListNode{
    public int key;
    public int value;
    public ListNode next;
    public ListNode(int key, int val){
        this.key = key;
        this.value = val;
        this.next = null;
    }
}
public class LRUCache {
    /*
    * @param capacity: An integer
    */
    private int capacity;
    private ListNode head, tail;
    private Map<Integer, ListNode> keyToPrev = new HashMap<>();
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        keyToPrev.put(-1, head);
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        if (!keyToPrev.containsKey(key)){
            return -1;
        }
        
        if (head.next.key == key){
            return head.next.value;
        }
        //1. 斷開, 把前後連起來
        ListNode prev = keyToPrev.get(key);
        ListNode curr = prev.next; 
        prev.next = curr.next;
        keyToPrev.put(curr.next.key, prev);
        
        //2. insert to head
        moveToHead(curr);
        return curr.value;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        if (get(key) != -1){
            keyToPrev.get(key).next.value = value;
            return;
        }
        
        if (keyToPrev.size() == capacity + 1){
            System.out.println(keyToPrev.size());
            ListNode end = keyToPrev.get(-1);
            keyToPrev.put(-1, keyToPrev.get(end.key));
            keyToPrev.get(end.key).next = tail;
            keyToPrev.remove(end.key);
        }
        
        ListNode curr = new ListNode(key, value);
        moveToHead(curr);
    }
    
    private void moveToHead(ListNode curr){
        ListNode temp = head.next;
        head.next = curr;
        curr.next = temp;
        keyToPrev.put(curr.key, head);
        keyToPrev.put(temp.key, curr);
    }
}
