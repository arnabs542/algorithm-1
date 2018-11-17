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

// 滾動數組
public class MovingAverage {
    /*
    * @param size: An integer
    */
    private double[] sum;
    private int id;
    private int size;
    public MovingAverage(int size) {
        sum = new double[size + 1];
        this.size = size;
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        id ++; 
        int length = sum.length;
        sum[id % length] = sum[(id - 1) % length] + val;
        if (id - size >= 0){
            return (sum[id % length] - sum[(id- size) % length]) / size;
        } else {
            return sum[id % length] / id;
        }
    }
}
