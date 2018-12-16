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
