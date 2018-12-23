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

class Event implements Comparable<Event>{
    static final int Event_START = 1;
    static final int Event_END = -1;

    public int time;
    public int type;
    public Event(int time, int type){
        this.time = time;
        this.type = type;
    }
    
    public int compareTo(Event event){
        if (event.time == this.time){
            return this.type - event.type;
        }
        return this.time - event.time;
    }
}
public class Solution {
    /**
     * @param seqA: the list of intervals
     * @param seqB: the list of intervals
     * @return: the time periods
     */
    public List<Interval> timeIntersection(List<Interval> seqA, List<Interval> seqB) {
        List<Event> eventList = new ArrayList<Event>();
        
        for (Interval seq: seqA){
            eventList.add(new Event(seq.start, Event.Event_START));
            eventList.add(new Event(seq.end, Event.Event_END));
        }
        
        for (Interval seq: seqB){
            eventList.add(new Event(seq.start, Event.Event_START));
            eventList.add(new Event(seq.end, Event.Event_END));
        }
        
        Collections.sort(eventList);
        
        List<Interval> result = new ArrayList<Interval>();
        
        int count = 0;
        Interval last = new Interval(0, 0);
        for (Event event: eventList){
            count = count + event.type;

            if (event.type == Event.Event_END && count == 1){ // end of both user online
                last.end = event.time;
                result.add(new Interval(last.start, event.time));
            }
            
            if (event.type == Event.Event_START && count == 2){ // start of both user online
                last.start = event.time;
            }
            
        }
        
        return result;
    }
}
