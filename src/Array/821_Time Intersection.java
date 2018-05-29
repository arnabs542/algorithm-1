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
class Event {
    public static final int EVENT_TYPE_IN = 1;
    public static final int EVENT_TYPE_OUT = -1; 
    int time;
    int type;
    public Event(int time, int type){
        this.time = time;
        this.type = type;
    }
}
public class Solution {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    static final int EVENT_TYPE_IN = 1;
    static final int EVENT_TYPE_OUT = -1;
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        
        List<Interval> result = new ArrayList<Interval>();
        List<Event> eventList = new ArrayList<Event>();
        for (Interval interval: seqA){
            eventList.add(new Event(interval.start, Event.EVENT_TYPE_IN));
            eventList.add(new Event(interval.end, Event.EVENT_TYPE_OUT));
        }
        
        for (Interval interval: seqB){
            eventList.add(new Event(interval.start, Event.EVENT_TYPE_IN));
            eventList.add(new Event(interval.end, Event.EVENT_TYPE_OUT));
        }
        
        eventList.sort(Comparator.comparing((Event event) -> event.time));
        int count = 0;
        Interval last = new Interval(0, 0);;
        for (Event event : eventList){
            count = count + event.type;
            if (event.type == Event.EVENT_TYPE_IN && count == 2){ // both users are online
                last.start = event.time;
            }
            
            if (event.type == Event.EVENT_TYPE_OUT && count == 1){ // end of both user online
                last.end = event.time;
                result.add(new Interval(last.start, last.end));
            }
        }
        
        return result;
    
    }
}
