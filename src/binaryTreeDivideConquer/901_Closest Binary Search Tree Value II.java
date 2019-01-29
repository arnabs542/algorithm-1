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
     * @param target: the given target
     * @param k: the given k
     * @return: k values in the BST that are closest to the target
     */
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List<Integer> treeList = new ArrayList<Integer>();
        List<Integer> result = new ArrayList<Integer>();

        inorder(root, treeList);
        
        int l = 0;
        int r = treeList.size() - 1;
        // 此處不能用二分法,因為target可能大於最大的數
        while(l + 1 < r){
            int mid = (l + r) / 2;
            if (treeList.get(mid) > target){
                l = mid;
            } else {
                r = mid;
            }
        }
        
        for (int i = 0; i < k; i ++){
            if (r > treeList.size() - 1){
                result.add(treeList.get(l));
                l --;
                continue;
            }
            
            if (l < 0){
                result.add(treeList.get(r));
                r ++;
                continue;
            }
            
            if (Math.abs(treeList.get(r) - target) < Math.abs(treeList.get(l) - target)){
                result.add(treeList.get(r));
                r ++;
            } else {
                result.add(treeList.get(l));
                l --;
            } 
        }
        
        return result;
       
    }
    
    private void inorder(TreeNode root, List<Integer> treeList)
    {
        if (root == null){
            return;
        }
        
        inorder(root.left, treeList);
        treeList.add(root.val);
        inorder(root.right, treeList);
    }
    
}
