package binaryTreeDivideConquer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by epingho on 2017/6/26.
 */
public class 480_BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<String>();
        if (root == null){
            return path;
        }

        List<String> pathL = binaryTreePaths(root.left);
        List<String> pathR = binaryTreePaths(root.right);

        for (String thisPath : pathL){
            path.add(root.val + "->" + thisPath);
        }

        for (String thisPath : pathR){
            path.add(root.val + "->" + thisPath);
        }

        if (pathL.size() == 0 && pathR.size() == 0){
            path.add(root.val + "");
        }

        return path;
    }
    
    
    //////////////////////
    //// Version 2    ////
    //////////////////////
    
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        List<Integer> path = new ArrayList<Integer>();

        if (root == null) {
            return result;
        }
        
        path.add(root.val);
        getPath(root, result, path);
        
        return result;
    }
    
    private void getPath(TreeNode node
                        , List<String> result
                        , List<Integer> path){
        if (node == null){
            return;
        }
        
        if (node.left == null && node.right == null){
            String pathS = path.get(0).toString();
            for (int i = 1; i < path.size(); i++){
                pathS = pathS + "->" + path.get(i).toString();
            }
            result.add(pathS);
        }
        
        if (node.left != null){
            path.add(node.left.val);
            getPath(node.left, result, path);
            path.remove(path.size()-1);
        }
        
         if (node.right != null){
            path.add(node.right.val);
            getPath(node.right, result, path);
            path.remove(path.size()-1);
        }
        
    }
    

}
