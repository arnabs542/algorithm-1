class Element{
    public int val;
    public int index;
    public Element(int val, int index){
        this.val = val;
        this.index = index;
    }
}

public class Solution {
    // Duplicates not accept in TreeSet
    // since there are duplicate in the question, so we can't directly use TreeSet<Integer>
    TreeSet<Element> maxQ; 
    TreeSet<Element> minQ;
    
    // 比較時要加上 val 相等時的判斷, 不然val相等, 不會被加入TreeSet
    private Comparator<Element> compareMaxQ = new Comparator<Element>(){
        public int compare(Element a, Element b){
            if (b.val == a.val) {
                return a.index - b.index;
            }
            return b.val - a.val;
        }
    };
    
    private Comparator<Element> compareMinQ = new Comparator<Element>(){
        public int compare(Element a, Element b){
            if (a.val == b.val) {
                return a.index - b.index;
            }
            return a.val - b.val;
        }
    };
    
    public List<Integer> medianSlidingWindow(int[] nums, int k) {
        maxQ = new TreeSet<Element>(compareMaxQ);
        minQ = new TreeSet<Element>(compareMinQ);
        
        int size = (k + 1)/2;
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < k; i ++){
            addToWindow(new Element(nums[i], i), size);
            if (i == k - 1){
                result.add(maxQ.first().val);
            }
        }
        
        for (int i = k; i < nums.length; i ++){
            removeFromWindow(new Element(nums[i - k], i -k));
            addToWindow(new Element(nums[i], i), size);
            result.add(maxQ.first().val);
        }
        
        return result;
    }
    
    private void removeFromWindow(Element e){
        if (maxQ.contains(e)){
             maxQ.remove(e);
        } else {
            minQ.remove(e);
        }
    }
    
    private void addToWindow(Element e, int size){
        maxQ.add(e);  //O(logn)

        if (maxQ.size() > size){
            minQ.add(maxQ.first());         //O(logn)
            maxQ.remove(maxQ.first());      //O(logn)
        } 
        
        if (minQ.size() > 0){
            if (maxQ.first().val > minQ.first().val){
                // 交換
                minQ.add(maxQ.first());
                maxQ.remove(maxQ.first());
                maxQ.add(minQ.first());
                minQ.remove(minQ.first());
            }    
        }
    }
}
