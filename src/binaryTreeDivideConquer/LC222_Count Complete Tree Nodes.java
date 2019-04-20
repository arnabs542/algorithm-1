// 拿起來直接count, complete tree特性... 好像沒用
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        
        int count_l = countNodes(root.left);
        int count_r = countNodes(root.right);
        return count_l + count_r + 1;
    }
}
