package breadthFirstSearch;

import java.util.ArrayList;

/**
 * Created by epingho on 2017/7/5.
 */
public class BinaryTreeLevelOrderTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList result = new ArrayList<>();
        if (root == null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> levelList = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode head = queue.poll();
                levelList.add(head.val);
                if (head.left != null){
                    queue.offer(head.left);
                }
                if (head.right != null){
                    queue.offer(head.right);
                }
            }
            result.add(levelList);
        }

        return result;
    }

}
