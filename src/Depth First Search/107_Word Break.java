class Solution {
    HashSet<String> dict = new HashSet<String>();
    HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict){
            dict.add(word);
        }
        
        return helper(s);
        
        
    }
    
    private boolean helper(String s){
        if (dict.contains(s)){
            return true;
        }
        
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        
        for (int i = 0; i < s.length(); i ++){
            //看右邊是不是在字典中
            String right = s.substring(i);
            if (dict.contains(right)){
                memo.put(right, true);
            } else {
                memo.put(right, false);
                continue;
            }
            
            //看左邊是不是在字典中
            String left = s.substring(0, i);
            boolean isLeft = helper(left);
        
            memo.put(left, isLeft);
            if (i == 0 || isLeft){
                memo.put(s, true);  
                return true;
            } 
        }
        
        memo.put(s, false);
        return false;
    }
}



class Solution {
    Set<String> dict = new HashSet<String>();
    HashMap<String, Boolean> memo = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        for (String word: wordDict){
            dict.add(word);
        }
        return DFS(s);
    }
    
    private boolean DFS(String s){
        if (dict.contains(s)){
            memo.put(s, true);
            return true;
        }
        
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        
        for (int i = 1; i < s.length(); i ++){
            String left = s.substring(0, i);
            String right = s.substring(i);
            if (!dict.contains(left)){
                continue;
            } 
            
            boolean isRight = DFS(right);
            memo.put(right, isRight);
            if (isRight){
                return true;
            }
        }
        
        memo.put(s, false);
        return false;
    }
}
