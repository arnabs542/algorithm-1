public class Solution {
    /**
     * @param pattern: a string, denote pattern string
     * @param teststr: a string, denote matching string
     * @return: an boolean, denote whether the pattern string and the matching string match or not
     */
    public boolean wordPattern(String pattern, String teststr) {
        String[] testList = teststr.split(" ");
        Map<Character, String> map = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i ++){
            char c = pattern.charAt(i);
            if (map.containsKey(c)){
                if (!map.get(c).equals(testList[i])){
                    return false;
                }
            } else {
                if (map.containsValue(testList[i])){
                    return false;
                }
                map.put(c, testList[i]);
            }
        }
        
        return true;
    }
}
