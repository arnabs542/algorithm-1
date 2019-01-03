// k rows, totall n element
// priority queue size: k
// priority queue offer: O(logk)
// priority queue poll: O(logk)
// => O(nlogk)

class Element{
    int row;
    int column;
    int value;
    public Element(int row, int column, int value){
        this.row = row;
        this.column = column;
        this.value = value;
    }
}

//PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);

public class Solution {
    /**
     * @param nums: the given k sorted arrays
     * @return: the median of the given k sorted arrays
     */
     
    private Comparator<Element> compareElement = new Comparator<Element>(){
        public int compare(Element e1, Element e2){
            return e1.value - e2.value;
        }
    };
    
    public double findMedian(int[][] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        
        PriorityQueue<Element> pq = new PriorityQueue<Element>(nums.length, compareElement);
        int elementCount = 0;
        for (int i = 0; i < nums.length; i ++){
            if (nums[i] == null || nums[i].length == 0){
                continue;
            }
            elementCount = elementCount + nums[i].length;
            pq.offer(new Element(i, 0, nums[i][0]));
        }
        
        int k = elementCount / 2 + 1;
        int i = 1;
        int m1 = 0;
        int m2 = 0;
        while(!pq.isEmpty() && i <= k){
            Element e = pq.poll();
            if (i + 1 == k){
                m1 = e.value;    
            }
            
            if (i == k){
                m2 = e.value;   
                break;
            }
            
            if (e.column + 1 < nums[e.row].length){
                pq.offer(new Element(e.row, e.column + 1, nums[e.row][e.column + 1]));
            } 
            i ++;
        }
        
        if (elementCount % 2 == 1){
            return m2;
        }
        
        //System.out.println(m1);
        //System.out.println(m2);
        return m1/2.0  + m2/2.0;
    }
    
   
}
