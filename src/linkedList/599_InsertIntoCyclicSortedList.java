package linkedList;

/**
 * Created by epingho on 2017/7/27.
 */
public class InsertIntoCyclicSortedList {
    public ListNode insert(ListNode node, int x) {
        if (node == null){
            node = new ListNode(x);
            node.next = node;
            return node;

        }

        ListNode p = node;
        ListNode prev = null;
        do {
            prev = p;
            p = p.next;
            if (x <= p.val && x >= prev.val){
                break;
            }

            if (prev.val > p.val && (x < prev.val && x < p.val)){
                break;
            }
        } while (p!= node);

        ListNode xNode = new ListNode(x);
        prev.next = xNode;
        xNode.next = p;

        return node;
    }

}

