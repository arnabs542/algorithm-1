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
