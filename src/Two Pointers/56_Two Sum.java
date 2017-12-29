public class Solution {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        
        int[] result = new int[2];
        
        for (int i = 0; i < numbers.length; i++){
            int remaining = target - numbers[i];

            if (hm.get(numbers[i]) != null){
                result[0] = hm.get(numbers[i]);
                result[1] = i;
                break;
            }
            
            int remaining = target - numbers[i];

            hm.put(remaining, i);
        }
        
        return result;
    }
}
