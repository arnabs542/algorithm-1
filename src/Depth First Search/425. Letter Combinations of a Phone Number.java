public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.equals("")){
            return result;
        }
        
        Map<Character, char[]> map = new HashMap<Character, char[]>();
        map.put('0', new char[]{});
        map.put('1', new char[]{});
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        dfs(result, new ArrayList<String>(), map, digits, 0);
        return result;
    }
    
    private void dfs(List<String> result,
                    List<String> subset,
                    Map<Character, char[]> map,
                    String digits,
                    int index){
                        
        if (subset.size() == digits.length()){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < subset.size(); i ++){
                sb.append(subset.get(i));
            }
            result.add(sb.toString());
            return;
        }
        
        char[] charArray = map.get(digits.charAt(index));
        for (int j = 0; j < charArray.length; j ++){
            subset.add(Character.toString(charArray[j]));
            dfs(result, subset, map, digits, subset.size());
            subset.remove(subset.size() - 1);
        }
    }
}
