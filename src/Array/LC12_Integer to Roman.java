class Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}; 
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        String result = "";
        for (int i = 0; i < nums.length; i ++){
            int times = num / nums[i];
            for (int j = 0; j < times; j ++){
                result = result + roman[i];
            }
            num = num - nums[i] * times;
        }
        
        return result;
    }
}
