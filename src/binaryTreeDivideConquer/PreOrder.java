package binaryTreeDivideConquer;
import java.util.ArrayList;

// preorder
// 根左右

////////////////////////
////  recirsion 
////////////////////////
public class PreOrder {

    public static void main(String[] args) {
        TreeNode testNode = new TreeNode(0);
        ArrayList<Integer> resultPreorderDivided = preorderDivided(testNode);

        ArrayList<Integer> resultPreorderTraversal = new ArrayList<Integer>();
        preorderTraversal(testNode, resultPreorderTraversal);

    }

    public static ArrayList<Integer> preorderDivided(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // null or leaf
        if (root == null) {
            return result;
        }

        // Divide
        ArrayList<Integer> left = preorderDivided(root.left);
        ArrayList<Integer> right = preorderDivided(root.right);

        // Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode root, ArrayList<Integer> result) {
       if (root == null){
           return result;
       }

       result.add(root.val);
       preorderTraversal(root.left, result);
       preorderTraversal(root.right, result);

    }


}
