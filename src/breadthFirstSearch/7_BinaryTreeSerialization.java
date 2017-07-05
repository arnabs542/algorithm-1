package breadthFirstSearch;

/**
 * Created by epingho on 2017/7/5.
 */
public class BinaryTreeSerialization {
    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        if (root == null){
            return "{}";
        }

        ArrayList<TreeNode> nodeList = new ArrayList<TreeNode>();
        nodeList.add(root);
        for (int i = 0; i < nodeList.size(); i++){
            TreeNode thisNode = nodeList.get(i);
            if (thisNode == null){
                continue;
            }
            nodeList.add(thisNode.left);
            nodeList.add(thisNode.right);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        sb.append(nodeList.get(0).val);
        for (int i = 1; i < nodeList.size(); i++){
            if (nodeList.get(i) == null){
                sb.append(",#");
            }else{
                sb.append(",");
                sb.append(nodeList.get(i).val);
            }
        }
        sb.append("}");

        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        data = data.replace("{", "").replace("}", "");
        if (data.equals("")){
            return null;
        }

        String[] dataArray = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(dataArray[0]));
        ArrayList<TreeNode> tempArray = new ArrayList<TreeNode>();
        tempArray.add(root);

        int index = 0;
        boolean isLeftChild = true;
        for (int i = 1; i < dataArray.length; i++) {
            if (!dataArray[i].equals("#")) {
                TreeNode node = new TreeNode(Integer.parseInt(dataArray[i]));
                if (isLeftChild) {
                    tempArray.get(index).left = node;
                } else {
                    tempArray.get(index).right = node;
                }
                tempArray.add(node);
            }
            if (!isLeftChild) {
                index++;
            }
            isLeftChild = !isLeftChild;
        }
        return root;

    }
}
