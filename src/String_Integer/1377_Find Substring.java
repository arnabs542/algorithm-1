// O(n * n)

public class Solution {
    /**
     * @param str: The string
     * @param k: The length of the substring
     * @return: The answer
     */
    public int findSubstring(String str, int k) {
        HashSet<String> result = new HashSet<>();
        
        int start = 0;
        HashSet<Character> cSet = new HashSet<>();
        for (int i = 0; i < str.length(); i ++){
            while (cSet.contains(str.charAt(i))){
                cSet.remove(str.charAt(start));
                start ++;
                continue;
            }
            
            cSet.add(str.charAt(i));
            if (cSet.size() == k){
                result.add(str.substring(start, i + 1));
                cSet.remove(str.charAt(start));
                start ++;
            }
        }
        
        return result.size();
    }
}
