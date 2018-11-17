public class MovingAverage {
    /*
    * @param size: An integer
    */
    int size;
    double sum;
    Queue<Integer> q;
    public MovingAverage(int size) {
        this.size = size;
        q = new LinkedList<Integer>();
    }

    /*
     * @param val: An integer
     * @return:  
     */
    public double next(int val) {
        q.offer(val);
        sum = sum + val;
        int qSize = q.size();
        if (qSize <= size){
            return sum / qSize;
        } else{
            sum = sum - q.poll();
            return sum / size;
        }
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
