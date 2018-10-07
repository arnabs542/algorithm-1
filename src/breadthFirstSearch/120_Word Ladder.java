public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start.equals(end)){
            return 1;
        }
        // add end to the dictionary;
        dict.add(end);
        int length = 1;
        Queue<String> q = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        
        q.offer(start);
        hs.add(start);
        
       // BFS
        while(!q.isEmpty()){
            int size = q.size();
            length ++;
            for (int i = 0; i < size; i ++){
                String thisWord = q.poll();
                ArrayList<String> thisWordDict = nextWordinDict(thisWord, dict);
                for (String nextWord: thisWordDict){
                    if (hs.contains(nextWord)){
                        continue;
                    }
                    if (nextWord.equals(end)){
                        return length;
                    }
                    hs.add(nextWord);
                    q.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private String replaceChar(String thisWord, int index, char replaceChar){
        char thisWordArray[] = thisWord.toCharArray();
        thisWordArray[index] = replaceChar;
        return new String(thisWordArray);  // O(L)
    }
    
    // find all neighbors in the dictionary
    private ArrayList<String> nextWordinDict(String thisWord, Set<String> dict){
        ArrayList<String> nextWords = new ArrayList<String>();
        // loop through 單字長度 O(L * 26)
        for(int i = 0; i < thisWord.length(); i ++){
            // loop through 26 characters
            for(char c = 'a'; c <= 'z'; c++){
                String newWord = replaceChar(thisWord, i, c);
                if (dict.contains(newWord)){
                    nextWords.add(newWord);
                }
            }
        }
        
        return nextWords;
    }
}



public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: An integer
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        // 1. put start in queue
        // 2. poll from queue, find what could be the next word from the dictionary
        // "hit" : "hot", 
        // 3. offer the word found in queue
        //// follow level order
        
        if (start.equals(end)){
            return 1;
        }
        // 1. add end word in dictionary
        dict.add(end);
        
        // 2. offer start in Queue
        Queue<String> q = new LinkedList<String>();
        HashSet<String> hs = new HashSet<String>();
        int count = 1;
        q.offer(start);
        hs.add(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i ++){
                String word = q.poll();
                List<String> neighbors = findNeighborsInDict(word, dict);
                for (int j = 0; j < neighbors.size(); j ++){
                    String thisNeighbor = neighbors.get(j);
                    if (hs.contains(thisNeighbor)){
                        continue;
                    } else{
                        if (thisNeighbor.equals(end)){
                            return count;
                        }
                        hs.add(thisNeighbor);
                        q.offer(thisNeighbor);
                    }
                }
            }
            count ++;
        }
        
        return 0;
    }
    
    private List<String> findNeighborsInDict(String word, Set<String> dict){
        List<String> neighbors = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c ++){
            for (int i = 0; i < word.length(); i ++){
                if (word.charAt(i) == c){
                    continue;
                }
                String newWord = replace(word, i, c);
                if (dict.contains(newWord)){
                    neighbors.add(newWord);
                }
            }
        }
        return neighbors;
    }
    
    private String replace(String word, int index, char c){
        char[] wordChar = word.toCharArray();
        wordChar[index] = c;
        return new String(wordChar);
    }
}
