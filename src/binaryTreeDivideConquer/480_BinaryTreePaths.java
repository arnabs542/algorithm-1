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

}
