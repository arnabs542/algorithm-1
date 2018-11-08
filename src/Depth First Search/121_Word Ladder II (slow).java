public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        //1. 用BFS找出最短路徑, 
        //and HashMap<String, List<String>> neighbors 
        //             字, 字典中可能的下一個字
        //2. 用DFS loop map 組合所有可行解
        //同一層可以重複
        Map<String, Set<String>> neighbors = new HashMap<>();
        BFS(start, end, dict, neighbors);
        List<List<String>> ladders = new ArrayList<>();
        List<String> subset = new ArrayList<String>();
        subset.add(start);
        System.out.println(neighbors);
        DFS(ladders, subset, neighbors, end, start);
        return ladders;

    }
    
    private void BFS(String start,
                    String end,
                    Set<String> dict,
                    Map<String, Set<String>> neighbors){
        
        Queue<String> q = new LinkedList<String>();
        Set<String> visitedWord = new HashSet<String>();
        boolean isEndFound = false;
        q.offer(start);
        visitedWord.add(start);
        while(!q.isEmpty() && !isEndFound){
            int size = q.size();
            List<String> currentLayerVisitedWord = new ArrayList<String>();

            for (int i = 0; i < size; i ++){
               String currentWord = q.poll();

                List<String> nextWord = findNextWrod(dict, currentWord, end);
                neighbors.put(currentWord, new HashSet<String>());
            
                for (String n: nextWord){
                    currentLayerVisitedWord.add(n);

                    if (n.equals(end)){
                        isEndFound = true;
                        neighbors.get(currentWord).add(n);

                    } else {
                       if (!visitedWord.contains(n)){
                        q.offer(n);
                        neighbors.get(currentWord).add(n);
                        } 
                    }
                } 
            }
            visitedWord.addAll(currentLayerVisitedWord);
        }
    }
    
    private List<String> findNextWrod(Set<String> dict, String word, String end){
        List<String> nextWord = new ArrayList<String>();
        for(int i = 0; i < word.length(); i ++){
            for (char c = 'a'; c <= 'z'; c ++){
                if (c != word.charAt(i)){
                    String next = word.substring(0, i) + c + word.substring(i + 1);
                    if (dict.contains(next) || next.equals(end)){
                        nextWord.add(next);
                    }
                }
            }
        }
        
        return nextWord;
    }
    
    private void DFS(List<List<String>> result,
                    List<String> subset,
                    Map<String, Set<String>> neighbors,
                    String end,
                    String currentWord){
        if (currentWord.equals(end)){
            result.add(new ArrayList<String>(subset));
            return;
        } 
        
        Set<String> next = neighbors.get(currentWord);
        if (next != null){
            for (String s: next){
                subset.add(s);
                DFS(result, subset, neighbors, end,  s);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
