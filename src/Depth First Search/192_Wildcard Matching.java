public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: is Match?
     */
    public boolean isMatch(String s, String p) {
        boolean[][] visited = new boolean[s.length()][p.length()];
        boolean[][] memo = new boolean[s.length()][p.length()];
        return isMatchHelper(s, 0, p, 0, visited, memo);
        
    }
    
    private boolean isMatchHelper(String s, int sIndex,
                        String p, int pIndex,
                        boolean[][] visited,
                        boolean[][] memo){
        
        // 如果p已經到底了, s 還沒到底, return false;
        if (pIndex == p.length()){
            return sIndex == s.length();
        }
        
        // 如果s已經到底了, p 全都是 *;
        if (sIndex == s.length()){
            return allStar(p, pIndex);
        }
        
        if (visited[sIndex][pIndex]){
            return memo[sIndex][pIndex];
        }
        
        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;
        if (pChar == '*'){
            match = (isMatchHelper(s, sIndex + 1, p, pIndex, visited, memo) ||
                    isMatchHelper(s, sIndex, p, pIndex + 1, visited, memo));
        } else {
            match = (canMatch(sChar, pChar) && 
                    isMatchHelper(s, sIndex + 1, p, pIndex + 1, visited, memo));
        }
        
        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }
    
    private boolean canMatch(char s, char p){
        return (s == p || p == '?');
    }
    
    private boolean allStar(String p, int pIndex){
        for (int i = pIndex; i < p.length(); i ++){
            if (p.charAt(i) != '*'){
                return false;
            }
        }
        
        return true;
    }
    
}
