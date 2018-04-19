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
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<Interval>();
        int index = 0;
        while (index < intervals.size() && newInterval.start >= intervals.get(index).start){
            index ++;
        }
        intervals.add(index, newInterval);
        
        Interval last = null;
        for (Interval item : intervals){
            if (last == null || last.end < item.start){
                last = item;
                result.add(item);
            }else{
                last.end = Math.max(item.end, last.end);
            }
        }
        return result;
    }
}



public class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    private Interval last = null;

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0){
            intervals.add(0, newInterval);
            return intervals;
        }
        
        List<Interval> result = new ArrayList<Interval>();
        int index = 0;
        boolean inserted = false;
        Interval curr = null;
        while ( index < intervals.size() && !inserted){
            if (intervals.get(index).start < newInterval.start){
                curr = intervals.get(index);
                index ++;
            }else{
                curr = newInterval;
                inserted = true;
            }
            
            mergeResult(curr, result);
        }
        
        while (index < intervals.size()){
            curr = intervals.get(index);
            mergeResult(curr, result);
            index ++;
        }
        
        if (!inserted){
            curr = newInterval;
            mergeResult(curr, result);
        }
        
        return result;
    }
    
    private void mergeResult(Interval curr, List<Interval> result){
            if (last == null || last.end < curr.start){
                last = curr;
                result.add(last);
            }else{
                last.start = Math.min(curr.start, last.start);
                last.end = Math.max(curr.end, last.end);
            }
        }
        
}
