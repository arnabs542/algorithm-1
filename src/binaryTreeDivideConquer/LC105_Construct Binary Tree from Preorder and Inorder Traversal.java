// preorder: Root, left, right
// inorder: left, Root, right
// recursive O(N)

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
    HashMap<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0){
            return null;
        }
        
        for (int i = 0; i < inorder.length; i ++){
            inorderMap.put(inorder[i], i);
        }
        
        return traverse(preorder, 0, preorder.length -1
                ,inorder, 0, inorder.length - 1);
    }
    
    private TreeNode traverse(int[] preorder, int startPre, int endPre,
                             int[] inorder, int startIn, int endIn){
        if (endIn < startIn || startPre > endPre){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[startPre]);
        int index = inorderMap.get(preorder[startPre]);
        root.left = traverse(preorder, startPre + 1, startPre + index - startIn,
                            inorder, startIn, index - 1);
        root.right = traverse(preorder, startPre + index - startIn + 1, endPre,
                            inorder, index + 1, endIn);
        
        return root;
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
