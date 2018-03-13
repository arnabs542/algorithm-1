/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> result = new ArrayList<DirectedGraphNode>();
        // create a map for <node, count # pointers to the node>
        HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for (DirectedGraphNode node: graph){
            for (DirectedGraphNode neighborNode: node.neighbors){
                if (map.containsKey(neighborNode)){
                    map.put(neighborNode, map.get(neighborNode) + 1);
                }else{
                    map.put(neighborNode, 1);
                }
            }
        }
        
        // if the node doesn't exist in map, then it's a start node
        // offer start node in the queue
        Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node: graph){
            if (!map.containsKey(node)){
                q.offer(node);
                result.add(node);
            }
        }
        
        // BFS
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for (DirectedGraphNode neighborNode: node.neighbors){
                map.put(neighborNode, map.get(neighborNode)-1);
                if (map.get(neighborNode) == 0){
                    result.add(neighborNode);
                    q.offer(neighborNode);
                }
            }
        }
        
        return result;
        
    }
}
