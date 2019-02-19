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
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subresult = new ArrayList<>();
        if (root == null){
            return result;
        }
        
        subresult.add(root.val);
        DFS(root, target, result, subresult);
        return result;
    }
    
    private void DFS(TreeNode root, int target,
                    List<List<Integer>> result, List<Integer> subresult){
        
        int sum = 0;
        for (int i = subresult.size() - 1; i >= 0; i --){
            sum = sum + subresult.get(i);
            if (sum == target){
                result.add(new ArrayList<Integer>(subresult.subList(i, subresult.size())));
            }
        }
               
        if (root.left != null){
            subresult.add(root.left.val);
            DFS(root.left, target, result, subresult);
            subresult.remove(subresult.size() - 1);
        }
        
        if (root.right != null){
            subresult.add(root.right.val);
            DFS(root.right,target, result, subresult);
            subresult.remove(subresult.size() - 1);
        }
    }
}
