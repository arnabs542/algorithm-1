

public class Solution {
    /*
     * @param : a string to be split
     * @return: all possible split string array
     */
    public List<List<String>> splitString(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s == null){
            return result;
        }
        
        if (s.length() == 0){
            result.add(new ArrayList<String>());
            return result;
        }
        
        List<String> subset = new ArrayList<String>();
        dfs(s, 0, result, subset);
        return result;
    }
    
    private void dfs(
            String s
            , int startIndex
            , List<List<String>> result
            , List<String> subset){
        
        if (startIndex == s.length()){
           result.add(new ArrayList(subset)); 
           return;
        }
        
        for (int j = 1; j < 3; j ++){
            if (startIndex + j <= s.length()){
                subset.add(s.substring(startIndex, startIndex + j));
                dfs(s, startIndex + j, result, subset);
                subset.remove(subset.size() - 1);
            }
        }
    }
}
