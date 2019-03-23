/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */


public class Solution {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        HashSet<ParentTreeNode> hs = new HashSet<>();
        // 把A的祖先都先放進 HashSet
        while (A != null){
            hs.add(A);
            A = A.parent;
        }
        
        // traverse B的祖先, 看有沒有在HashSet中
        while (B != null){
            if (hs.contains(B)){
                return B;
            }
            B = B.parent;
        }
        
        return null;
    }
}
