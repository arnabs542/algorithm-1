public class MovingAverage {
    /*
    * @param size: An integer
    */
    private Queue<Integer> q = new LinkedList<Integer>();
    private double sum = 0;
    private int size;
    public MovingAverage(int size) {
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        if (q.size() == this.size){
            int firstVal = q.poll();
            sum = sum - firstVal;    
        }
        
        q.offer(val);
        sum = sum + val;
        return sum / q.size();
    }
}
