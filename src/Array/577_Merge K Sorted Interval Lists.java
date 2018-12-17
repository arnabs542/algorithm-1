// Sol 1.

/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Element{
    public int row;
    public int col;
    public Interval interval;
    public Element(int row, int col, Interval interval){
        this.row = row;
        this.col = col;
        this.interval = interval;
    }
}

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
     
    private Comparator intervalCompare = new Comparator<Element>(){
        public int compare(Element elem1, Element elem2){
            return elem1.interval.start - elem2.interval.start;
        }
    };
    
    List<Interval> result = new ArrayList<Interval>();
    Interval last;
    
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        Queue<Element> q = new PriorityQueue<Element>(intervals.size(), intervalCompare);
        for(int i = 0; i <intervals.size(); i ++){
            if (intervals.get(i) == null || intervals.get(i).size() == 0){
                continue;
            }
            q.offer(new Element(i, 0, intervals.get(i).get(0))); 
        }
        
        while(!q.isEmpty()){
            Element thisElement = q.poll();
            merge(thisElement.interval);
            if (thisElement.col + 1 < intervals.get(thisElement.row).size()){
                q.offer(new Element(thisElement.row, thisElement.col + 1,  intervals.get(thisElement.row).get(thisElement.col + 1)));
            }
        }
        
        return result;
    }
    
    private void merge(Interval curr){
        if (result.size() == 0){
            last = curr;
            result.add(last);
        } else {
            if (curr.start > last.end){
                last = curr;
                result.add(last);
            } else {
                last.start = Math.min(curr.start, last.start);
                last.end = Math.max(curr.end, last.end);    
            }
        }
    }
}


// Sol 2.


/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: the given k sorted interval lists
     * @return:  the new sorted interval list
     */
    
    public List<Interval> mergeKSortedIntervalLists(List<List<Interval>> intervals) {
        return divide(0, intervals.size() -1, intervals);
    }
    
    private List<Interval> divide(int start, int end, List<List<Interval>> intervals){
        if (start >= end){
            return intervals.get(start);
        }
        int mid = (start + end)/2;
        List<Interval> left = divide(start, mid, intervals);
        List<Interval> right = divide(mid + 1, end, intervals);

        return merge(left, right);
    }
    
    private List<Interval> merge(List<Interval> left, List<Interval> right){
        List<Interval> result = new ArrayList<Interval>();
        int l = 0;
        int r = 0;
        while(l < left.size() && r < right.size()){
            if (left.get(l).start < right.get(r).start){
                generateResult(left.get(l), result);
                l ++;
            } else {
                generateResult(right.get(r), result);
                r ++;
            }
        }
        
        while (l < left.size()){
            generateResult(left.get(l), result);
            l ++;
        }
        
        while (r < right.size()){
            generateResult(right.get(r), result);
            r ++;
        }
        
        return result;
    }
    
    private void generateResult(Interval curr, List<Interval> result){
        if (result.size() == 0){
            result.add(curr);
        } else {
            Interval last = result.get(result.size() - 1);
            if (curr.start > last.end){
                result.add(curr);
            } else {
                last.start = Math.min(curr.start, last.start);
                last.end = Math.max(curr.end, last.end);
            }
        }
        
        //return result;
    }
    
}
