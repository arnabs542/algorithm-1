public class Solution {
    /**
     * @param s: input string
     * @return: the longest palindromic substring
     */
    // O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return "";
        }
        
        String longestP = s.substring(0, 1);
        // the middle of palindrome can be 1 character or 2 character
        for (int i = 1; i < s.length(); i ++){
            // check 1 character in the middle
            String pal1 = getPalindrome(s, i, i);
            if (pal1.length() > longestP.length()){
                longestP = pal1;
            }
            // check 2 characters in the middle
            String pal2 = getPalindrome(s, i - 1, i);
            if (pal2.length() > longestP.length()){
                longestP = pal2;
            }
        }
        
        return longestP;
    }
    
    private String getPalindrome(String s, int mid, int mid1){
        int left = mid;
        int right = mid1;
        
        while (left >= 0 && right < s.length()){
            if (s.charAt(left) != s.charAt(right)){
                break;
            }
            left --;
            right ++;
        }
        
        // current s.charAt(left), s.charAt(right) failed;
        // move back to previous left and right position
        return s.substring(left + 1, right); 
    }
}
