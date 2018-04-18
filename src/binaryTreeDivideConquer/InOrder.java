package binaryTreeDivideConquer;

import java.util.ArrayList;

// Inorder
// 左根右

////////////////////////
////  recirsion 
////////////////////////

public class InOrder {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (root == null){
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));

        return result;
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

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<NodeVisit> visitStack = new Stack<NodeVisit>();
        
        visitStack.push(new NodeVisit(root, false));
        while(!visitStack.isEmpty()){
            NodeVisit thisNode = visitStack.pop();
            if (thisNode.node == null){
                continue;
            }
            
            if (thisNode.isChecked == true){
                result.add(thisNode.node.val);
            }else{
                visitStack.push(new NodeVisit(thisNode.node.right, false));
                visitStack.push(new NodeVisit(thisNode.node, true));
                visitStack.push(new NodeVisit(thisNode.node.left, false));
            }       
        }
        
        return result;
    }
}
