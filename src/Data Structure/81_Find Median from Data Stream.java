public class Solution {
    /**
     此題目定義
     count is even: [1, 19] => median = 1
     count i odd: [3, 1, 2] => median = 2
     
     [4, 5, 1, 3, 2, 6, 0]
     maxQ: 由小到大左半邊的數, 
     minQ: 由小到大右半邊的數
     */
     
    private Comparator<Integer> compareMaxQ = new Comparator<Integer>(){
        public int compare(Integer a, Integer b){
            return b - a;
        }
    };
    
    private Queue<Integer> maxQ;
    private Queue<Integer> minQ;
    public int[] medianII(int[] nums) {
        
        int count = nums.length;
        maxQ = new PriorityQueue<Integer>(count, compareMaxQ);
        minQ = new PriorityQueue<Integer>(count);
        int[] result = new int[count];
        
        for (int i = 0; i < nums.length; i ++){
            int ans = getMedian(nums[i], i + 1);
            result[i] = ans;
        }
        
        return result;
        
    }
    
    //[4, 5, 1, 3, 2, 6, 0]
    private int getMedian(int val, int numberOfElement){
        // 先加到 maxQ
        maxQ.offer(val);
        
        if ( numberOfElement % 2 == 1){
            if (minQ.isEmpty()){
                return maxQ.peek();
            } else {
                // numberOfElement is odd
                // 有大於maxQ 有大於minQ的部分交換
                if (maxQ.peek() > minQ.peek()){
                    minQ.offer(maxQ.poll());
                    maxQ.offer(minQ.poll());
                } 
            }
        } else {
            // 把大的放到右邊(minQ); 因為題目對於median的定義, 分配之後median在maxQ
            minQ.offer(maxQ.poll());
        }
        return maxQ.peek();
    }
    
}

//maxQ: -10, 
//minQ: 5


