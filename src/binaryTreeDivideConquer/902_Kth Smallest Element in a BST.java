/**
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
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
     
    public int index  = 0;
    public int kth = 0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return kth;
    }
    
    private void inorder(TreeNode root, int k){
        if (root == null){
            return;
        }
        
        inorder(root.left, k);
        index ++;
        if (index == k){
            kth = root.val;
        }
        
        if (index < k){
            inorder(root.right, k);
        }
        
    }
}

/**

Follow up: 二叉树经常被修改

在 TreeNode 中增加一个 counter，代表整个树的节点个数
也可以用一个 HashMap<TreeNode, Integer> 来存储某个节点为代表的子树的节点个数
在增删查改的过程中记录不断更新受影响节点的 counter
在 kthSmallest 的实现中用类似 Quick Select 的算法去找到 kth smallest element
时间复杂度为 O(h)，h 为树的高度。
Strong Hire: 能够答出 Follow Up 的算法，并写出kthSmallest核心代码（不需要写增删查改，45分钟写
不完的）， bug free or minor bug，不需要提示
Hire / Weak Hire : 能够答出 Follow up 的算法，大致写出 kthSmallest 核心代码，存在一定bug，或者需
要提示
 */

public class Solution {
    /**
     * @param root: the given BST
     * @param k: the given k
     * @return: the kth smallest element in BST
     */
     
    // L, root, R
    HashMap<TreeNode, Integer> hm = new HashMap<>();
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        getSmallerNodeCount(root);
        return getkth(root, k);
    }
    
    private void getSmallerNodeCount(TreeNode root){
        if (root == null){
            return;
        }
        
        getSmallerNodeCount(root.left);
        count ++;
        hm.put(root, count);
        getSmallerNodeCount(root.right);
    }
    
    private int getkth(TreeNode root, int k){
        int count = hm.get(root);
        if (count == k){
            return root.val;
            
        } else if (count > k){
            return getkth(root.left, k);
            
        } else {
            return getkth(root.right, k);
        }
    }
}
