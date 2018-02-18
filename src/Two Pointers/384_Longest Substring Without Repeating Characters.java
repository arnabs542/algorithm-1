public class Solution {
    /**
     * @param s: a string
     * @return: an integer
     */
    public int lengthOfLongestSubstring(String s) {
        int[] characterList = new int[256];
        int j = 0;
        int substringLen = 0;
        
        for (int i = 0; i < s.length(); i++){
            while( j < s.length() && characterList[s.charAt(j)] == 0){
                characterList[s.charAt(j)] = 1;
                substringLen = Math.max(substringLen, j - i + 1);
                j ++;
            }
            
            characterList[s.charAt(i)] = 0;
        }
        
        return substringLen;
    }
}
