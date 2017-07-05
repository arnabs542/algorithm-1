package breadthFirstSearch;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by epingho on 2017/7/5.
 */
public class SearchGraphNodes {
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {

        if (graph == null || graph.size() == 0){
            return null;
        }

        Queue<UndirectedGraphNode> thisQ = new LinkedList<>();
        HashSet<UndirectedGraphNode> hash = new HashSet<>();
        thisQ.offer(node);
        hash.add(node);

        while (!thisQ.isEmpty()){
            UndirectedGraphNode thisNode = thisQ.poll();
            if (values.get(thisNode) == target){
                return thisNode;
            }
            for (UndirectedGraphNode neighbor: thisNode.neighbors){
                if (hash.contains(neighbor)){
                    continue;
                }else{
                    hash.add(neighbor);
                    thisQ.offer(neighbor);
                }
            }
        }

        return null;
    }
}
