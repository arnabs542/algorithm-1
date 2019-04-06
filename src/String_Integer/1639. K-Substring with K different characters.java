public class Solution {
    /**
     * @param stringIn: The original string.
     * @param K: The length of substrings.
     * @return: return the count of substring of length K and exactly K distinct characters.
     */
    public int KSubstring(String stringIn, int K) {
        HashSet<String> result = new HashSet<>();
        //int count = 0;
        HashSet<Character> hs = new HashSet<>();
        
        int start = 0;
        for (int i = 0; i < stringIn.length(); i ++){
            char c = stringIn.charAt(i);
            while (hs.contains(c)){
                hs.remove(stringIn.charAt(start));
                start ++;
            }
            
            hs.add(c);
            if (hs.size() == K){
                result.add(stringIn.substring(start, i + 1));
                //count ++;
                hs.remove(stringIn.charAt(start));
                start ++;
            }
        }
        
        return result.size();
        //return count;
    }
}
