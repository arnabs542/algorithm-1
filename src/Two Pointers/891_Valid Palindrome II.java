public class Solution {
    /**
     * @param s: a string
     * @return: nothing
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }
            
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
        }
        
        return isSubstringPalindrome(s, left + 1, right) || isSubstringPalindrome(s, left, right - 1);
    }
    
    private boolean isSubstringPalindrome(String s, int left, int right){
        while(left < right){
            if (s.charAt(left) == s.charAt(right)){
                left ++;
                right --;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
