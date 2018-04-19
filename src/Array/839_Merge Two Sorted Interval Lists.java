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
     * @param list1: one of the given list
     * @param list2: another list
     * @return: the new sorted list of interval
     */
    private Interval last = null;
    public List<Interval> mergeTwoInterval(List<Interval> list1, List<Interval> list2) {
        List<Interval> result = new ArrayList<Interval>();
        
        if (list1 == null || list2 == null){
            return result;
        }
        
        Interval curr = null;
        int list1Index = 0, list2Index = 0;
        while (list1Index < list1.size() && list2Index < list2.size()){
            // 看要從哪個list拿出來
            if (list1.get(list1Index).start < list2.get(list2Index).start){
                curr = list1.get(list1Index);
                list1Index ++;
            }else{
                curr = list2.get(list2Index);
                list2Index ++;
            }
            
            mergeResult(curr, result);
        }
        
        while (list1Index < list1.size()){
            curr = list1.get(list1Index);
            list1Index ++;
            mergeResult(curr, result);
        }
        
        while (list2Index < list2.size()){
            curr = list2.get(list2Index);
            list2Index ++;
            mergeResult(curr, result);
        }
        
        return result;
    }
    
    private void mergeResult(Interval curr, List<Interval> result){
        if (last == null || last.end < curr.start){
            // 沒有交集, 直接加入result
            last = curr;
            result.add(last);
        } else {
            // 與last有交集, merge進入last
            last.start = Math.min(curr.start, last.start);
            last.end = Math.max(curr.end, last.end);
        }
    }
}
