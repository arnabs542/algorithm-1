class Solution {
    public int myAtoi(String str) {
        if (str == null){
            return 0;
        }
        str = str.trim();
        
        if (str.length() == 0){
            return 0;
        }
        
        int index = 0;
        int sign = 1;
        if (str.charAt(index) == '-'){
            sign = -1;
            index ++;
        } else if(str.charAt(index) == '+'){
            index ++;
        }
        
        if(index < str.length() && !Character.isDigit(str.charAt(index))){
            return 0;
        }
        
        long num = 0;
        while (index < str.length() && Character.isDigit(str.charAt(index))){
            num = num * 10 + str.charAt(index) - '0';
            if (num > Integer.MAX_VALUE){
                break;
            }
            index ++;
        }
        
        if (num * sign >= Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        if (num * sign <= Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        
        return (int)num * sign;
    }
}
