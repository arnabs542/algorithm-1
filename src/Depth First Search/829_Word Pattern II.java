public class Solution {
    /**
     * @param pattern: a string,denote pattern string
     * @param str: a string, denote matching string
     * @return: a boolean
     */
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>(); //[a: red, b: blue]
        Set<String> set = new HashSet<>(); // [red, blue]
        return match(pattern, str, map, set);
    }
    
    private boolean match(String pattern,
                        String str,
                        Map<Character, String> map,
                        Set<String> set){
        
        if (pattern.length() == 0){
            return (str.length() == 0);
        }
        char c = pattern.charAt(0);
        if (map.containsKey(c)){
            if (!str.startsWith(map.get(c))){
                return false;
            }
            
            // 直接找下一個
            return match(pattern.substring(1),
                        str.substring(map.get(c).length()),
                        map,
                        set);
        }
    
        
        for (int i = 0; i < str.length(); i ++){
            String word = str.substring(0, i + 1);
            if (set.contains(word)){
                continue;
            }
            
            map.put(c, word);
            set.add(word);
            if (match(pattern.substring(1),
                        str.substring(i + 1),
                        map,
                        set)){
                    return true;            
                } 
            map.remove(c);
            set.remove(word);
        }
        return false;
    }
}
