public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<String, ArrayList<String>> memo = new HashMap<>();
        return wordBreakHelper(s, wordDict, memo);
    }
    
    public List<String> wordBreakHelper(String s, 
                            Set<String> wordDict,
                            Map<String, ArrayList<String>> memo) {
                                
        if (memo.containsKey(s)){
            return memo.get(s);
        }
        
        ArrayList<String> result = new ArrayList<String>();
        if (wordDict.contains(s)){
            result.add(s);
        }
        
        for (int i = 0; i < s.length(); i ++){
            // 看看右邊有沒有在字典
            String sRight = s.substring(i);
            if (!wordDict.contains(sRight)){
                continue;
            }
            String sLeft = s.substring(0, i);
            List<String> segmentation = wordBreakHelper(sLeft, wordDict, memo);
            for (String segment: segmentation){
                result.add(segment + " " + sRight);
            }
        }
        
        memo.put(s, result);
        System.out.println(memo);

        return result;

    }
}
