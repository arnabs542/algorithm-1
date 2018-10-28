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
