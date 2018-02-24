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
    /*
     * @param A: an integer array
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length == 0){
            return null;
        }
        
        if (A.length == 1){
            return new TreeNode(A[0]);
        }else{
            return buildTree(A, 0, A.length - 1);
        }
    }
    
    private TreeNode buildTree(int[] A, int start, int end){
        if (start > end){
            return null;
        }
        
        int mid = start + (end - start)/2;
        TreeNode root = new TreeNode(A[mid]);
        TreeNode left = buildTree(A, start, mid -1);
        TreeNode right = buildTree(A, mid + 1, end);
        
        root.left = left;
        root.right = right;
        
        return root;
    }
}
