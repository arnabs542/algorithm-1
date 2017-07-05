package breadthFirstSearch;

import java.util.*;

/**
 * Created by epingho on 2017/7/5.
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (n == 0){
            return false;
        }

        if (edges.length != n-1){
            return false;
        }

        Map<Integer, Set<Integer>> graph = getGraph(n, edges);
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> hash = new HashSet<>();

        queue.offer(0);
        hash.add(0);

        while (!queue.isEmpty()){
            int thisNode = queue.poll();
            for (int neighbor: graph.get(thisNode)){
                if (hash.contains(neighbor)){
                    continue;
                }else{
                    hash.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return (hash.size() == n);
    }

    public Map<Integer, Set<Integer>>getGraph(int n, int[][] edges){
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < n; i ++){
            graph.put(i, new HashSet<Integer>());
        }

        for (int i = 0; i < edges.length; i ++){
            int v = edges[i][0];
            int u = edges[i][1];
            graph.get(v).add(u);
            graph.get(u).add(v);
        }

        return graph;
    }
}
