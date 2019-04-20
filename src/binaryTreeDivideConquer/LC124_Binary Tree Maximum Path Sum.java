//time: O(N) 

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
有4种情况要考虑
left + root
right + root
root
left + right + root
不断往上传递的值 只可能是 1， 2， 3中的一种
第四种情况只可能保存在 max里面 而不可能在 curr_max

curr_max是上传到上一级用的 在上一级 可以用左边的和右边的路径再组合 
但是第四种情况是已经穿过root的路径 到上一级就用不了了 不可能跟上一级的root在一起组成新的路径了 所以用于更新max以后就不能用了
*/

// 1. 每個點先找出 max in 3 scenarios: (root, root + left, root + right)
// 2. 記錄全局 max
class Solution {
    public int maxPathSum(TreeNode root) {
        sum(root);
        return max;
    }
    
    private int max = Integer.MIN_VALUE;
    private int sum(TreeNode root){
        if (root == null){
            return 0;
        }
        
        int sumL = sum(root.left);
        int sumR = sum(root.right);
        int currMax = Math.max(Math.max(root.val + sumR, root.val + sumL), root.val);
        
        max = Math.max(max, Math.max(currMax, root.val + sumR + sumL));
        return currMax;
    }
}
