public class Solution {
    /**
     [4, 5, 1, 3, 2, 6, 0]
     maxQ: 由小到大左半邊的數, maxQ.peek()為左半邊最大的數 => mdeian
     minQ: 由小到大右半邊的樹, minQ.peek()為右半邊最小的數 => (minQ.peek + max.peek)/2 => mdeian
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
    
    private int getMedian(int val, int numberOfElement){
        // 先加到 maxQ
        maxQ.offer(val);
        if ( numberOfElement % 2 == 1){
            if (minQ.isEmpty()){
                return maxQ.peek();
            } else {
                if (maxQ.peek() > minQ.peek()){
                    minQ.offer(maxQ.poll());
                    maxQ.offer(minQ.poll());
                } 
            }
        } else {
            // 把大的放到右邊(minQ)
            minQ.offer(maxQ.poll());
        }
        return maxQ.peek();
    }
    
}

//maxQ: -10, 
//minQ: 5


