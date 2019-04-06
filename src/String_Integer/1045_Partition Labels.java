public class Solution {
    /**
     * @param S: a string
     * @return: a list of integers representing the size of these parts
     */
    // O(n)
    public List<Integer> partitionLabels(String S) {
        List<Integer> result = new ArrayList<Integer>();
        
        int[] indexOfLast = new int[26];
        for (int i = 0; i < S.length(); i ++){
            indexOfLast[S.charAt(i) - 'a'] = i;
        }
        
        int start = 0;
        int end = 0;
        for (int i = 0; i < S.length(); i ++){
            // 找一個目前最大的
            end = Math.max(end, indexOfLast[S.charAt(i) - 'a']);
            if (i == end){
                result.add(i - start + 1);
                start = i + 1;
            }
        }
        
        return result;
    }
}
