public class Solution {
    /**
     * @param words: a list of words
     * @return: a string which is correct order
     */
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> neighbors = new HashMap<>();
        Map<Character, Integer> dependencyCount = new HashMap<>();
        
        // create node list
        for (int i = 0; i < words.length; i ++){
            for (int j = 0; j < words[i].length(); j ++){
                Character c = words[i].charAt(j);
                if (!neighbors.containsKey(c)){
                   neighbors.put(c, new HashSet<Character>()); 
                   dependencyCount.put(c, 0);
                }
            }
        }
        
        // find neighbors
        // 比較前後兩個字, 看第一個不同的字母, 後者為前者的neighbor
        // ex: "wrt" "wrf" => {t, [f]}
        //     "wrf", "er" => {w, [e]}
        for (int i = 0; i < words.length - 1; i ++){
            int index = 0;
            while(index < words[i].length() && index < words[i + 1].length()){
                Character thisC = words[i].charAt(index);
                Character neighborC = words[i + 1].charAt(index);

                if (thisC != neighborC){
                    if (!neighbors.get(thisC).contains(neighborC)){
                        neighbors.get(thisC).add(neighborC);
                        // find dependencyCount; 一樣的dependency不用重複算
                        dependencyCount.put(neighborC, dependencyCount.get(neighborC) + 1);
                        // 找到一個不同的字母後, 就可以換下一個word
                        break;
                    }
                }
                index ++;
            }
        }
        
        System.out.println(neighbors);
        System.out.println(dependencyCount);

        // Use PriorityQueue to get lexicographically;
        Queue<Character> q = new PriorityQueue<Character>();
        for (Character c : dependencyCount.keySet()){
            if (dependencyCount.get(c) == 0){
                q.offer(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while(!q.isEmpty()){
            Character c = q.poll();
            result.append(c);
            Set<Character> neighborsList = neighbors.get(c);
            for (Character n: neighborsList){
                dependencyCount.put(n, dependencyCount.get(n) - 1);
                if (dependencyCount.get(n) == 0){
                    q.offer(n);   
                }
            }
        }
        
        System.out.println(result);

        // double check if result has all the characters
        if (result.length() != dependencyCount.size()){
            return "";
        }
        
        return result.toString();
    }
}
