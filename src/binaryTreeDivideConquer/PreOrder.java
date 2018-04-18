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

////////////////////////
////   iteration    
////////////////////////

public class Solution {
    public class NodeVisit{
        public TreeNode node;
        public boolean isChecked;
        public NodeVisit(TreeNode node, boolean isChecked){
            this.node = node;
            this.isChecked = isChecked;
        }
    }
    
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        
        Stack<NodeVisit> visitStack = new Stack<NodeVisit>();
        visitStack.push(new NodeVisit(root, false));
        
        while(!visitStack.isEmpty()){
            NodeVisit thisNodeVisit = visitStack.pop();
            if (thisNodeVisit.node == null){
                continue;
            }
            
            if (thisNodeVisit.isChecked){
                result.add(thisNodeVisit.node.val);
            }else{
                thisNodeVisit.isChecked = true;
                visitStack.push(new NodeVisit(thisNodeVisit.node.right, false));
                visitStack.push(new NodeVisit(thisNodeVisit.node.left, false));
                visitStack.push(thisNodeVisit);
            }
        }
        
        return result;
    }
}
