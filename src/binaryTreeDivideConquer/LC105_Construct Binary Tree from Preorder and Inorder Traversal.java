// preorder: Root, left, right
// inorder: left, Root, right
// recursive O(N)

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length){
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd
                               , int[] inorder, int inStart, int inEnd){
        if (inStart > inEnd){
            return null;
        }
        int rootIndex = findRootInorder(inorder, preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, preStart + 1, preStart + rootIndex - inStart
                             , inorder, inStart, rootIndex - 1);
        root.right = buildTree(preorder, preStart + rootIndex - inStart + 1, preEnd
                             , inorder, rootIndex + 1, inEnd);
        
        return root;
    }
    
    private int findRootInorder(int[] inorder, int target){
        for (int i = 0; i < inorder.length; i ++){
            if (inorder[i] == target){
                return i;
            }
        }
        
        return -1;
    }
}


// iterative
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        TreeNode currRoot = null;
        int preIndex = 0;
        int inIndex = 0;
        TreeNode root = null;
        while (preIndex < preorder.length && inIndex < inorder.length){
            do {
                TreeNode n = new TreeNode(preorder[preIndex]);
                if (root == null){
                    root = n;
                }
                s.push(n);
                if (s.isEmpty()){
                    currRoot.right = n;
                } else {
                    s.peek().left = n;
                }
                if (preIndex == preorder.length - 1){
                    break;
                }
                preIndex ++;  
            } while (preIndex < preorder.length && preorder[preIndex] == inorder[inIndex]);
            
            while (!s.isEmpty() && inIndex < inorder.length && s.peek().val == inorder[inIndex]){
                currRoot = s.pop();         
                inIndex ++;
            }
            
        }
        
        return root;
    }
}
