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
class Result{
    public int count;
    public int sum;
    public Result(int c, int s){
        this.count = c;
        this.sum = s;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    // define average
    private double maxAvg = (double)Integer.MIN_VALUE;
    private TreeNode r = null;
    public TreeNode findSubtree2(TreeNode root) {
        if (root == null){
            return null;
        }
                System.out.println(maxAvg);

        getMaxAvg(root);
        
        return r;
    }
    
    private Result getMaxAvg(TreeNode root){
        if (root == null){
            return new Result(0, 0);
        }
        
        Result l_result = getMaxAvg(root.left);
        Result r_result = getMaxAvg(root.right);
        int sum = root.val + l_result.sum + r_result.sum;
        int count = 1 + l_result.count + r_result.count;
        double avg = (double) sum / count;

        if (avg > maxAvg){
            maxAvg = avg;
            r = root;
        }
        return new Result(count, sum);
    }
}
