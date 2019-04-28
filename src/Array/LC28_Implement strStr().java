class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()){
            return -1;
        }
        
        //if (haystack.length() == 0 && needle.length())
        
        for (int i = 0; i < haystack.length() - needle.length() + 1; i ++){
            int hayIndex = i;
            for (int j = 0; j < needle.length(); j ++){
                if (haystack.charAt(hayIndex) != needle.charAt(j)){
                    break;
                }
                hayIndex ++;
            }
            if (hayIndex == i + needle.length()){
                return i;
            }
        }
        
        return -1;
    }
}
