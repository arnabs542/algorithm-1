// Sol 1.)

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
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        int result = 0;
        int count = 0;
        List<int[]> stat = new ArrayList<>();
        for (Interval interval: airplanes){
            stat.add(new int[]{interval.start, 1}); // in
            stat.add(new int[]{interval.end, -1}); // out
        }
        
        stat.sort(Comparator.comparing((int[] p) -> p[0]).thenComparing((int[] q) -> q[1]));
        for (int i = 0; i < stat.size(); i ++){
            count = count + stat.get(i)[1];
            result = Math.max(count, result);
        }
        
        return result;
    }
}



// Sol 2.)
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
 
class Point{
    public static int EVENT_START = 1;
    public static int EVENT_END = -1;
    int time;
    int event;
    public Point(int time, int event){
        this.time = time;
        this.event = event;
    }
}
public class Solution {
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    private Comparator<Point> comparePoint = new Comparator<Point>(){
        public int compare(Point a, Point b){
            if (a.time == b.time){
                return a.event - b.event;
            }
          return a.time - b.time;  
        }
    };
    
    int maxCount = Integer.MIN_VALUE;
    public int countOfAirplanes(List<Interval> airplanes) {
        if (airplanes == null || airplanes.size() == 0){
            return 0;
        }
        List<Point> pointList = new ArrayList<>();
        for (Interval interval: airplanes){
            pointList.add(new Point(interval.start, Point.EVENT_START));
            pointList.add(new Point(interval.end, Point.EVENT_END));
        }
        
        Collections.sort(pointList, comparePoint);
        
        int count = 0;
        for (Point point: pointList){
            count = count + point.event;
            maxCount = Math.max(count, maxCount);
        }
        
        return maxCount;
    }
}
