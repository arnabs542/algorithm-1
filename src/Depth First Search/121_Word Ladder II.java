public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    /* begin = "red"
     * end = " tax"
     * ["ted", "tex", "red", "tax", "tad", "den", "rex", "pee"]
     [[red, ted, tad, tax],
      [red, ted, tex, tax],
      [red, rex, tex, tax]]
    */  
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // add start and end to dict
        dict.add(start);
        dict.add(end);

        // BFS from start to find 1) all the path 2) count each from start to each word
        Map<String, Set<String>> graph = new HashMap<>();
        // red: [ted, rex]; ted: [tex, tad]; rex: [tex]; tex: [tax]; tad: [tax]; 
        for (String d: dict){
             graph.put(d, new HashSet<String>());
        }
        Map<String, Integer>stepCount = new HashMap<>();
        // red: 0; ted; 1; rex: 1; tex: 2; tad: 2; tax: 3
        BFS(dict, start, end, graph, stepCount);
        System.out.println(graph);
        System.out.println(stepCount);

        
        // DFS from start to follow shortest path
        List<List<String>> result = new ArrayList<>();
        List<String> subset = new ArrayList<String>();
        subset.add(start);
        DFS(start, end, graph, stepCount, result, subset);
        return result;
    }
    
    private void BFS(Set<String> dict, 
                    String start,
                    String end,
                    Map<String, Set<String>> graph,
                    Map<String, Integer> stepCount){
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        stepCount.put(start, 0);
        while(!q.isEmpty()){
            int size = q.size();
            // 分層, in the same level, word in dictionary can be used in the next level
            for (int i = 0; i < size; i ++){
                String curr = q.poll();
                if (curr.equals(end)){
                    break;
                }
                List<String> nextNeighbors = getNeighbors(curr, dict);

                for (String n : nextNeighbors){
                    // ****
                    graph.get(curr).add(n); 

                    if (!stepCount.containsKey(n)){
                        q.offer(n);
                        stepCount.put(n, stepCount.get(curr) + 1);
                    }
                    // ****
                }
            }
        }
    }
    
    private void DFS(String curr,
                    String end,
                    Map<String, Set<String>> graph,
                    Map<String, Integer>stepCount,
                    List<List<String>> result,
                    List<String> subset){

        if (curr.equals(end)){
            result.add(new ArrayList<String>(subset));
            return;
        }
        
        for (String n: graph.get(curr)){
            if (stepCount.get(n) == stepCount.get(curr) + 1 ){
               subset.add(n);
               DFS(n, end, graph, stepCount, result, subset); 
               subset.remove(subset.size() - 1);
            }
        }
    }
    
    
    private List<String> getNeighbors(String word,
                                     Set<String> dict){
        List<String> neighbors = new ArrayList<String>();
        for (int i = 0; i < word.length(); i ++){
            for (char c = 'a'; c <= 'z'; c++){
                if (c == word.charAt(i)){
                    continue;
                }
                String nextWord = word.substring(0, i) + c + word.substring(i + 1);

                if (dict.contains(nextWord)){
                    neighbors.add(nextWord);
                }
            }
        }
        
        return neighbors;
    }
}
