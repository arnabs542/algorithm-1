public class Solution {
    /*
    * @param k: An integer
    */
    private PriorityQueue<Integer> pq;
    
    private int k;
    
    public Solution(int k) {
        pq = new PriorityQueue<Integer>(k);
        this.k = k;
    }

    /*
     * @param num: Number to be added
     * @return: nothing
     */
    public void add(int num) {
        pq.offer(num);
        if (pq.size() > k){
            pq.poll();
        }
    }

    /*
     * @return: Top k element
     */
    public List<Integer> topk() {
        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result, Collections.reverseOrder());
        
        return result;
    }
}
