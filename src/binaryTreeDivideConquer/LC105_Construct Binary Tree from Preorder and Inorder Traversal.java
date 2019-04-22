// preorder: Root, left, right
// inorder: left, Root, right
// recursive

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
