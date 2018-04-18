public class Solution {
    /**
     * @param arrs: the arrays
     * @return: the number of the intersection of the arrays
     */
    public int intersectionOfArrays(int[][] arrs) {
        HashMap<Integer, Integer> lookup = new HashMap<Integer, Integer>();
        int intersectionSize = 0;
        
        for (int i = 0; i < arrs.length; i ++){
            for (int j = 0; j < arrs[i].length; j ++){
                int count = 1;
                if (lookup.containsKey(arrs[i][j])){
                    count = lookup.get(arrs[i][j]) + 1;
                }
                lookup.put(arrs[i][j], count);
                if (count == arrs.length){
                    intersectionSize ++;
                }
            }
        }
        
        return intersectionSize;
    }
}
