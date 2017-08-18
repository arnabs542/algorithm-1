class Solution {
    /**
     * @param nums an integer unsorted array
     * @param k an integer from 1 to n
     * @return the kth largest element
     */
    public int kthLargestElement2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        
        for (int i = 0; i < nums.length; i ++){
            pq.offer(nums[i]);
            if (i > k -1){
                pq.poll();
            }
        }
        
        return pq.poll();
    }
};
