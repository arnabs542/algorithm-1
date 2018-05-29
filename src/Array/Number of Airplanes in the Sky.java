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
