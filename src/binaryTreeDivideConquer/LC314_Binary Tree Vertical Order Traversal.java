// sol 1. treemap O(n * logn)

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Node{
    TreeNode treenode;
    int col;
    public Node(TreeNode treenode, int col){
        this.treenode = treenode;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        BFS(root);
        for (int i: hm.keySet()){
            result.add(hm.get(i));
        }
        
        return result;
    }
    
    private TreeMap<Integer, List<Integer>> hm = new TreeMap<>(); // col, node values
    private void BFS(TreeNode root){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(root, 0));
        hm.put(0, new ArrayList<Integer>());
        hm.get(0).add(root.val);
        
        while (!q.isEmpty()){
            Node n = q.poll();
            if (n.treenode.left != null){
                q.offer(new Node(n.treenode.left, n.col - 1));
                addToHm(n.col - 1, n.treenode.left.val);
            }
            
            if (n.treenode.right != null){
                q.offer(new Node(n.treenode.right, n.col + 1));
                addToHm(n.col + 1, n.treenode.right.val);
            }
        }
    }
    
    private void addToHm(int col, int val){
        if (hm.containsKey(col)){
            hm.get(col).add(val);
        } else {
            hm.put(col, new ArrayList<Integer>());
            hm.get(col).add(val);
        }
    }
}
