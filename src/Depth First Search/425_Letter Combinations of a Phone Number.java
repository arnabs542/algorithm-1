public class Solution {
    /**
     * @param digits: A digital string
     * @return: all posible letter combinations
     */
    String[] KEYBOARD = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();

        if (digits == null || digits.length() == 0){
            return result;
        }
        DFS(digits, "", result, 0);
        return result;
    }
    
    private void DFS(String digits,
                    String subset,
                    List<String> result,
                    int startIndex){
        
        if (digits.length() == subset.length()){
            result.add(subset);
            return;
        }
        
        for (int i = startIndex; i < digits.length(); i ++){
            String keyboard = KEYBOARD[Integer.parseInt(digits.substring(i, i + 1))];
            for (int j = 0; j < keyboard.length(); j ++){
                DFS(digits, subset + keyboard.substring(j, j + 1), result, i + 1);
            }
        }
    }
}

// Time: O(3 ^ M * 4 ^ N) // M: number of numbers with 3 letters; N: number of numbers with 4 letters
// Space: O(3 ^ M * 4 ^ N)
class Solution {
    HashMap<Character, Character[]> hm = new HashMap<>();
        
    public List<String> letterCombinations(String digits) {
        hm.put('2', new Character[]{'a', 'b', 'c'});
        hm.put('3', new Character[]{'d', 'e', 'f'});
        hm.put('4', new Character[]{'g', 'h', 'i'});
        hm.put('5', new Character[]{'j', 'k', 'l'});
        hm.put('6', new Character[]{'m', 'n', 'o'});
        hm.put('7', new Character[]{'p', 'q', 'r', 's'});
        hm.put('8', new Character[]{'t', 'u', 'v'});
        hm.put('9', new Character[]{'w', 'x', 'y', 'z'});
        
        char[] c = digits.toCharArray();
        List<String> result = new ArrayList<>();
        if (c == null || c.length == 0){
            return result;
        }
        DFS(c, 0, result, "");
        return result;
    }
    
    private void DFS(char[] c
                    , int index
                    , List<String> result
                    , String subset){
        
        if (index == c.length){
            result.add(new String(subset));
            return;
        }
        
        Character[] letters = hm.get(c[index]);
        if (letters == null || letters.length == 0){
            subset = subset + "";
            DFS(c, index + 1, result, subset);
        } else {
            for  (int j = 0; j < letters.length; j ++){
            subset = subset + letters[j];
            DFS(c, index + 1, result, subset);
            subset = subset.substring(0, subset.length() - 1);
            }
        }
    }
}
