class Solution {
    /*
     * @param nums an integer array
     * @param k an integer
     * @return the top k largest numbers in array
     */
    public int[] topk(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
             public int compare(Integer o1, Integer o2) {
                 if(o1 > o2) {
                     return 1;
                 } else if(o1 < o2) {
                     return -1;
                 } else {
                     return 0;
                 }
             }
         });

        
        for (int i : nums) {
             pq.add(i);
             if (pq.size() > k) {
                pq.poll();
             }
         }

         int[] result = new int[k];
         for (int i = 0; i < result.length; i++) {
             result[k - i - 1] = pq.poll();
         }
         return result;

    }
};

