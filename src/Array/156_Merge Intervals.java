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
     * @param intervals: interval list.
     * @return: A new interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        Interval last = null;
        List<Interval> result = new ArrayList<Interval>();
        
        intervals.sort(Comparator.comparing(i -> i.start));
        
        for (Interval item : intervals){
            
            if (last == null ||
                last.end < item.start){
                last = item;
                result.add(item);
            }else{
                last.start = Math.min(item.start, last.start);
                last.end = Math.max(item.end, last.end);
            }
        }
        
        return result;
    }
}
