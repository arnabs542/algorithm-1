public class Solution {
    /*
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        boolean[][] memo = new boolean[s.length()][s.length()];
        dfs(s, 0, new ArrayList<String>(), result, memo);
        return result;
    }
    
    private void dfs(String s,
                    int startIndex,
                    List<String> subset,
                    List<List<String>> result,
                    boolean[][] memo){
        
        if (startIndex > s.length() - 1){
            result.add(new ArrayList<String>(subset));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i ++){
            String x = s.substring(startIndex, i + 1);
            if (memo[startIndex][i] || isPalidrome(x)){
                memo[startIndex][i] = true;
                subset.add(x);
                dfs(s, i + 1, subset, result, memo);
                subset.remove(subset.size() - 1);
            }
        }
    }
    
    private boolean isPalidrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i ++, j --){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}
