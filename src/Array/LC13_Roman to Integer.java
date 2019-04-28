// 前面的value比後面的value小, 表示減去
// ex: IV => 1 < 5 => 5 -1 = 4
// ex: VI => 5 > 1 => 5 +1 = 6


class Solution {
    public int romanToInt(String s) {
        char[] input = s.toCharArray();
        HashMap<Character, Integer> hm = new HashMap<>();
        hm.put('I', 1);
        hm.put('V', 5);
        hm.put('X', 10);
        hm.put('L', 50);
        hm.put('C', 100);
        hm.put('D', 500);
        hm.put('M', 1000);
        int result = 0;
        int i = 0;
        while(i < input.length){
            if (i + 1 < input.length && hm.get(input[i]) < hm.get(input[i + 1])){
                result = result + hm.get(input[i + 1]) - hm.get(input[i]);
                i = i + 2;
            } else {
                result = result + hm.get(input[i]);
                i ++;
            }
        }
        
        return result;
    }
}
