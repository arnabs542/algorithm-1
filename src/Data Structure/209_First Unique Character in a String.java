// Solution 1. use extra space - hashmap O(2L) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        char result = Character.MIN_VALUE;
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        char[] strArray = str.toCharArray();
        for (int i = 0; i < strArray.length; i ++){
            if (hm.containsKey(strArray[i])){
                hm.put(strArray[i], hm.get(strArray[i]) + 1); 
            } else {
                hm.put(strArray[i], 1);
            }
        }
        
        for (int i = 0; i < strArray.length; i ++){
            if (hm.get(strArray[i]) == 1){
                result = strArray[i];
                break;
            }
        }
        
        return result;
    }
}

// Solution 2. use extra space - int[256] O(2L) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        int[] map = new int[256];
        for (char c: str.toCharArray()){
            map[c] = map[c] + 1;
        }
        
        for (char c: str.toCharArray()){
            if (map[c] == 1){
                return c;
            }
        }
        
        return ' ';
    }
}

// Solution 3. No extra space - loop 2 times O(L^2) L: length of string
public class Solution {
    /**
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        for (int i = 0; i < str.length(); i ++){
            boolean unique = true;
            int j = str.length() - 1;

            while(j >= 0){
                if (i != j && str.charAt(i) == str.charAt(j)){
                    unique = false;
                    break;
                }
                j --;
            } 
            if (unique){
                return str.charAt(i);
            }
        }
        return ' ';
    }
}
