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
