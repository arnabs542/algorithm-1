package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/7/4.
 */
public class BinaryTreeLongestConsecutiveSequence {
    public int maxLength;
    public int longestConsecutive(TreeNode root) {
        maxLength = 0;
        helper(root);
        return maxLength;
        // Write your code here

    }

    public int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        // starting from root
        int subTreeLength = 1;
        int lengthL = helper(root.left);
        int lengthR = helper(root.right);

        if (root.left !=null && root.left.val - root.val == 1){
            subTreeLength = Math.max(subTreeLength, lengthL + 1);
        }

        if (root.right !=null && root.right.val - root.val == 1){
            subTreeLength = Math.max(subTreeLength, lengthR + 1);
        }

        if (subTreeLength > maxLength){
            maxLength = subTreeLength;
        }

        return subTreeLength;
    }
}
