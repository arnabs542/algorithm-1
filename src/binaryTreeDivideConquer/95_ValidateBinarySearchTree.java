
public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long min, long max){
        if (root == null){
            return true;
        }
        
        if (root.val >= max || root.val <= min){
            return false;
        }
        
        boolean leftResult = helper(root.left, min, root.val);
        boolean rightResult = helper(root.right, root.val, max);
        return leftResult && rightResult;
    }
