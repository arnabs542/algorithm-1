// 判斷root是否在區間內,
// 在區間內, root.left, root.right各自下去
// 不再區間內, 判斷要trim left or right
// trim left => root = 遞歸root.right
// trim right => root = 遞歸root.left


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
     * @param root: given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree 
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        if (root == null){
            return null;
        }
        
        if (root.val <= maximum && root.val >= minimum){
            root.left = trimBST(root.left, minimum, maximum);
            root.right = trimBST(root.right, minimum, maximum);
        } else if (root.val > maximum){
            root = trimBST(root.left, minimum, maximum);
        } else if (root.val < minimum){
            root = trimBST(root.right, minimum, maximum);
        }
        
        return root;
    }
}
