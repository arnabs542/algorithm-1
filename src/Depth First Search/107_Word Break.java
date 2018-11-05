public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        if (s.equals("") && dict.size() == 0){
            return true;
        }
        Map<String, Boolean> memo = new HashMap<>();
        boolean result = helper(s, memo, dict);
        System.out.println(memo);
        return result;
    }
    
    private boolean helper(String s,
                        Map<String, Boolean> memo,
                        Set<String> dict){

        if (dict.contains(s)){
            return true;
        }
        
        if (memo.containsKey(s)){
            return true;
        }
        
        for (int i = 0; i < s.length(); i++){
            // 看看右邊是不是在字典中
            String sRight = s.substring(i);
            
            if (!dict.contains(sRight)){
                continue;
            }
            
            // 看看左邊
            String sLeft = s.substring(0, i);
            boolean leftInDict = helper(sLeft, memo, dict);
            if (i == 0 || leftInDict){
                memo.put(s, true);
                return true;
            }
        }
        
        return false;
    }
}
