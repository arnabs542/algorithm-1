public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3){
            return -1;
        }
        
        Arrays.sort(numbers);
        int bestAns = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i ++){
            int start = i + 1;
            int end = numbers.length - 1;
            while (start < end){
                int ans = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - ans) < Math.abs(target - bestAns)){
                    bestAns = ans;
                }
                if (ans < target){
                    start ++;
                }else{
                    end --;
                }
            }
        }
        
        return bestAns;
    }
}
