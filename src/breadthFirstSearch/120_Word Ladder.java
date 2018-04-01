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
