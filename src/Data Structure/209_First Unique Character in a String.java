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
