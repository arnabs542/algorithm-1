package binaryTreeDivideConquer;

/**
 * Created by epingho on 2017/6/24.
 */


import java.lang.Math; // headers MUST be above the first class

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class TreeNode
{
  public int val;
  public TreeNode left, right;
  public TreeNode(int val)
  {
    this.val = val;
    this.left = this.right = null;
  }
}

public class TreeOperation
{
  // arguments are passed using the text field below this editor
  public static void main(String[] args)
  {    
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(2);
    TreeNode t3 = new TreeNode(3);
    TreeNode t4 = new TreeNode(4);
    TreeNode t5 = new TreeNode(5);
    TreeNode t6 = new TreeNode(6);

    t1.left = t2;
    t1.right = t3;
    
    t2.left = t4;
    
    t3.left = t5;
    t5.right = t6;
    
    System.out.println(getDepthRec(t1));

  }  
  
  public static int getNumNodeRec(TreeNode node){
    
    if (node == null){
    	return 0;
    }else{
    	System.out.println(node.val);
    }
        
    return getNumNodeRec(node.left) + getNumNodeRec(node.right);
  }
  
  // public static getNumNode(TreeNode node)
  public static int getDepthRec(TreeNode node){
    if (node == null){
    	return 0;
    }
    
    return Math.max(getDepthRec(node.left), getDepthRec(node.right)) + 1;
  }
}


