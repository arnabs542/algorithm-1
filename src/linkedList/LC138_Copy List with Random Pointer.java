/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        HashMap<Node, Node> hm = new HashMap<>(); // old node, new node;
        Node newHead = new Node();
        Node curr = newHead;
        while (head != null){
            if (!hm.containsKey(head)){
                Node newNode = new Node(head.val);
                hm.put(head, newNode);
            }
            curr.next = hm.get(head);
            if (head.random != null){
                if (!hm.containsKey(head.random)){
                    Node newRandomNode = new Node(head.random.val);
                    hm.put(head.random, newRandomNode);
                }
                curr.next.random = hm.get(head.random);
            }
            head = head.next;
            curr = curr.next;
        }
        
        return newHead.next;
    }
}
