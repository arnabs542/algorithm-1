public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        if (s == null || s.length() == 0){
            return result;
        }
        
        List<String> temp = new ArrayList<String>();
        dfs(s, 0, temp, result);
        return result;
    }
    
    private void dfs(String s
            , int startIndex
            , List<String> temp
            , List<List<String>> result){
                
        if (startIndex == s.length()){
            result.add(new ArrayList<String>((temp)));
            return;
        }
        
        for (int i = startIndex; i < s.length(); i ++){
            String x = s.substring(startIndex, i + 1);
            if (!isPalindrome(x)){
                continue;
            }
            temp.add(x);
            dfs(s, i + 1, temp, result);
            temp.remove(temp.size() - 1);
        }
    }
    
    private boolean isPalindrome(String s){
        for (int i = 0, j = s.length() - 1; i < j; i ++, j --){
            if (s.charAt(i) != s.charAt(j)){
                return false;
            }
        }
        
        return true;
    }
}
